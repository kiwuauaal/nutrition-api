package com.nutrition.api.util

import com.nutrition.api.dto.FoodItemDto
import com.nutrition.api.dto.NutritionInfoDto
import com.nutrition.api.dto.NutritionSummaryDto
import com.nutrition.api.model.FOOD_DATABASE
import com.nutrition.api.model.NutritionInfo
import org.springframework.stereotype.Component

@Component
class NutritionCalculator {

    companion object {
        val ACTIVITY_MULTIPLIERS = mapOf(
            "sedentary" to 1.2,
            "light" to 1.375,
            "moderate" to 1.55,
            "active" to 1.725,
            "very_active" to 1.9
        )
    }

    fun calculateBmr(weightKg: Double, heightCm: Double, age: Int, gender: String): Double {
        return if (gender.lowercase() == "male") {
            88.362 + (13.397 * weightKg) + (4.799 * heightCm) - (5.677 * age)
        } else {
            447.593 + (9.247 * weightKg) + (3.098 * heightCm) - (4.330 * age)
        }
    }

    fun calculateTdee(bmr: Double, activityLevel: String): Double {
        val multiplier = ACTIVITY_MULTIPLIERS[activityLevel.lowercase()] ?: 1.55
        return (bmr * multiplier).roundTo(2)
    }

    fun calculateNutrition(foodData: NutritionInfo, weight: Double): NutritionInfoDto {
        val factor = weight / 100.0
        return NutritionInfoDto(
            calorie = (foodData.calories * factor).roundTo(2),
            proteine_g = (foodData.protein * factor).roundTo(2),
            carboidrati_g = (foodData.carbs * factor).roundTo(2),
            grassi_g = (foodData.fat * factor).roundTo(2),
            fibre_g = foodData.fiber?.let { (it * factor).roundTo(2) }
        )
    }

    fun calculateTotalNutrition(foods: List<FoodItemDto>): NutritionSummaryDto {
        var totalCalories = 0.0
        var totalProtein = 0.0
        var totalCarbs = 0.0
        var totalFat = 0.0
        var totalFiber = 0.0

        foods.forEach { foodItem ->
            val nutritionInfo = FOOD_DATABASE[foodItem.name.lowercase()]
            if (nutritionInfo != null) {
                val factor = foodItem.weight / 100.0
                totalCalories += nutritionInfo.calories * factor
                totalProtein += nutritionInfo.protein * factor
                totalCarbs += nutritionInfo.carbs * factor
                totalFat += nutritionInfo.fat * factor
                nutritionInfo.fiber?.let { totalFiber += it * factor }
            }
        }

        return NutritionSummaryDto(
            calorieTotali = totalCalories.roundTo(2),
            proteineTotaliG = totalProtein.roundTo(2),
            carboidratiTotaliG = totalCarbs.roundTo(2),
            grassiTotaliG = totalFat.roundTo(2),
            fibreTotaliG = totalFiber.roundTo(2)
        )
    }

    private fun Double.roundTo(decimals: Int): Double {
        var multiplier = 1.0
        repeat(decimals) { multiplier *= 10 }
        return kotlin.math.round(this * multiplier) / multiplier
    }
}