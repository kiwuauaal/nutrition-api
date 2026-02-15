package com.nutrition.api.controller

import com.nutrition.api.dto.*
import com.nutrition.api.service.NutritionService
import com.nutrition.api.util.FuzzySearchUtil
import com.nutrition.api.util.NutritionCalculator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/")
class NutritionController {

    @Autowired
    private lateinit var nutritionService: NutritionService

    @Autowired
    private lateinit var nutritionCalculator: NutritionCalculator

    @Autowired
    private lateinit var fuzzySearchUtil: FuzzySearchUtil

    @GetMapping
    fun home(): ResponseEntity<ApiResponse<Map<String, Any>>> {
        val response = mapOf(
            "message" to "🔥 Nutrition API Ultimate - Production Ready!",
            "version" to "4.0",
            "features" to mapOf(
                "authentication" to "✅ JWT Authentication",
                "database" to "✅ Supabase Integration",
                "documentation" to "✅ Swagger/OpenAPI Docs",
                "deployment" to "✅ Docker Ready",
                "security" to "✅ JWT Authentication"
            ),
            "endpoints" to mapOf(
                "CORE" to listOf("/foods", "/calculate", "/calculate-bmr"),
                "USER" to listOf("/users", "/users/{id}", "/users/goals"),
                "MEALS" to listOf("/meals", "/meals/duplicate"),
                "ANALYTICS" to listOf("/stats/{id}/week", "/charts/{id}/weekly")
            ),
            "docs" to "/swagger"
        )

        return ResponseEntity.ok(ApiResponse(success = true, data = response))
    }

    @GetMapping("/health")
    fun healthCheck(): ResponseEntity<ApiResponse<Map<String, Any>>> {
        val response = mapOf(
            "status" to "healthy",
            "version" to "4.0",
            "database" to "connected", // Simplified for now
            "uptime" to "0", // Simplified for now
            "features" to mapOf(
                "supabase" to true,
                "jwt" to true
            )
        )

        return ResponseEntity.ok(ApiResponse(success = true, data = response))
    }

    @PostMapping("/calculate-bmr")
    fun calculateBmr(@RequestBody request: CalculateBmrRequest): ResponseEntity<ApiResponse<CalculateBmrResponse>> {
        try {
            val bmr = nutritionCalculator.calculateBmr(
                request.weight,
                request.height,
                request.age,
                request.gender
            )
            val tdee = nutritionCalculator.calculateTdee(bmr, request.activityLevel)

            val goalsSuggestion = CalculateBmrResponse(
                bmr = bmr,
                tdee = tdee,
                goalsSuggestion = GoalsSuggestionResponse(
                    mantenimentoPeso = tdee,
                    perditaPeso = tdee - 500,
                    aumentoMassa = tdee + 500
                )
            )

            return ResponseEntity.ok(ApiResponse(success = true, data = goalsSuggestion))
        } catch (e: Exception) {
            return ResponseEntity.badRequest().body(ApiResponse(success = false, error = e.message))
        }
    }

    @GetMapping("/foods/fuzzy-search")
    fun fuzzySearch(
        @RequestParam q: String,
        @RequestParam(defaultValue = "10") limit: Int
    ): ResponseEntity<ApiResponse<FuzzySearchResponse>> {
        try {
            val results = fuzzySearchUtil.fuzzyFoodSearch(q, limit)
            val response = FuzzySearchResponse(
                query = q,
                resultsCount = results.size,
                foods = results
            )

            return ResponseEntity.ok(ApiResponse(success = true, data = response))
        } catch (e: Exception) {
            return ResponseEntity.badRequest().body(ApiResponse(success = false, error = e.message))
        }
    }

    @PostMapping("/calculate")
    fun calculateNutrition(@RequestBody request: CalculateNutritionRequest): ResponseEntity<ApiResponse<CalculateNutritionResponse>> {
        try {
            val totalNutrition = nutritionCalculator.calculateTotalNutrition(request.foods)
            val response = CalculateNutritionResponse(
                riepilogoNutrizionale = totalNutrition
            )

            return ResponseEntity.ok(ApiResponse(success = true, data = response))
        } catch (e: Exception) {
            return ResponseEntity.badRequest().body(ApiResponse(success = false, error = e.message))
        }
    }

    @PostMapping("/users")
    fun createUser(@RequestBody request: CreateUserRequest): ResponseEntity<ApiResponse<CreateUserResponse>> {
        try {
            val user = nutritionService.createUser(request)
            val response = CreateUserResponse(
                userId = user.id.toString(),
                userData = UserResponse(
                    id = user.id.toString(),
                    email = user.email,
                    name = user.name,
                    age = user.age,
                    weight = user.weight,
                    height = user.height,
                    gender = user.gender.name.lowercase(),
                    activityLevel = user.activityLevel.name.lowercase()
                )
            )

            return ResponseEntity.ok(ApiResponse(success = true, data = response))
        } catch (e: Exception) {
            return ResponseEntity.badRequest().body(ApiResponse(success = false, error = e.message))
        }
    }
}