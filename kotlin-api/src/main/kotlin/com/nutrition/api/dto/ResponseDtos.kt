package com.nutrition.api.dto

import com.nutrition.api.model.Gender
import com.nutrition.api.model.ActivityLevel

// Response DTOs
data class CalculateBmrResponse(
    val bmr: Double,
    val tdee: Double,
    val goalsSuggestion: GoalsSuggestionResponse
)

data class GoalsSuggestionResponse(
    val mantenimentoPeso: Double,
    val perditaPeso: Double,
    val aumentoMassa: Double
)

data class FuzzySearchResponse(
    val query: String,
    val resultsCount: Int,
    val foods: List<FoodSearchResultDto>
)

data class FoodSearchResultDto(
    val nome: String,
    val categoria: String,
    val similarity: Int,
    val nutrizionePer100g: NutritionInfoDto
)

data class NutritionInfoDto(
    val calorie: Double,
    val proteine_g: Double,
    val carboidrati_g: Double,
    val grassi_g: Double,
    val fibre_g: Double?
)

data class CalculateNutritionResponse(
    val riepilogoNutrizionale: NutritionSummaryDto
)

data class NutritionSummaryDto(
    val calorieTotali: Double,
    val proteineTotaliG: Double,
    val carboidratiTotaliG: Double,
    val grassiTotaliG: Double,
    val fibreTotaliG: Double
)

data class UserResponse(
    val id: String,
    val email: String,
    val name: String,
    val age: Int,
    val weight: Double,
    val height: Int,
    val gender: String,
    val activityLevel: String
)

data class CreateUserResponse(
    val userId: String,
    val userData: UserResponse
)

data class SetUserGoalsResponse(
    val goals: UserGoalsResponse
)

data class UserGoalsResponse(
    val dailyCalories: Int,
    val macroPercentages: MacroPercentagesDto
)

data class LogMealResponse(
    val mealId: String,
    val mealData: LogMealRequest
)

data class SetReminderResponse(
    val message: String,
    val reminder: ReminderDto
)

data class ReminderDto(
    val userId: String,
    val mealTime: String,
    val message: String
)

data class ShareDietResponse(
    val message: String,
    val sharingRecord: SharingRecordDto
)

data class SharingRecordDto(
    val userId: String,
    val recipientEmail: String,
    val permissionLevel: String
)

data class AwardBadgeResponse(
    val message: String,
    val badge: BadgeDto
)

data class BadgeDto(
    val userId: String,
    val badgeId: String
)

data class ApiResponse<T>(
    val success: Boolean,
    val data: T? = null,
    val error: String? = null
)