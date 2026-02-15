package com.nutrition.api.util

import com.nutrition.api.dto.FoodSearchResultDto
import com.nutrition.api.dto.NutritionInfoDto
import com.nutrition.api.model.FOOD_CATEGORIES
import com.nutrition.api.model.FOOD_DATABASE
import org.springframework.stereotype.Component

@Component
class FuzzySearchUtil {

    fun fuzzyFoodSearch(query: String, limit: Int = 10): List<FoodSearchResultDto> {
        val queryNormalized = normalizeFoodName(query)
        val foodNames = FOOD_DATABASE.keys.toList()

        // Simple fuzzy matching algorithm (Levenshtein distance based)
        val matches = foodNames.map { foodName ->
            val similarity = calculateSimilarity(queryNormalized, normalizeFoodName(foodName))
            Pair(foodName, similarity)
        }.filter { it.second > 60 } // Only include matches with similarity > 60
         .sortedByDescending { it.second } // Sort by similarity descending
         .take(limit) // Take top 'limit' matches

        return matches.map { (foodName, similarity) ->
            val nutritionData = FOOD_DATABASE[foodName]!!
            val category = getCategoryForFood(foodName)

            FoodSearchResultDto(
                nome = foodName,
                categoria = category,
                similarity = similarity,
                nutrizionePer100g = NutritionInfoDto(
                    calorie = nutritionData.calories,
                    proteine_g = nutritionData.protein,
                    carboidrati_g = nutritionData.carbs,
                    grassi_g = nutritionData.fat,
                    fibre_g = nutritionData.fiber
                )
            )
        }
    }

    private fun normalizeFoodName(name: String): String {
        if (name.isEmpty()) return ""
        return name.lowercase().trim().replace(Regex("\\s+"), " ")
    }

    private fun calculateSimilarity(str1: String, str2: String): Int {
        // Simple ratio calculation based on common substrings
        val maxLen = maxOf(str1.length, str2.length)
        if (maxLen == 0) return 100

        // Calculate longest common subsequence
        val lcsLength = longestCommonSubsequence(str1, str2)
        return ((lcsLength.toDouble() / maxLen) * 100).toInt()
    }

    private fun longestCommonSubsequence(str1: String, str2: String): Int {
        val m = str1.length
        val n = str2.length
        val dp = Array(m + 1) { IntArray(n + 1) }

        for (i in 1..m) {
            for (j in 1..n) {
                if (str1[i - 1] == str2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1
                } else {
                    dp[i][j] = maxOf(dp[i - 1][j], dp[i][j - 1])
                }
            }
        }

        return dp[m][n]
    }

    private fun getCategoryForFood(foodName: String): String {
        for ((category, foods) in FOOD_CATEGORIES) {
            if (foodName in foods) {
                return category
            }
        }
        return "other"
    }
}