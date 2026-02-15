package com.nutrition.api.dto

import com.nutrition.api.model.Gender
import com.nutrition.api.model.ActivityLevel

// Request DTOs
data class CalculateBmrRequest(
    val weight: Double,
    val height: Double,
    val age: Int,
    val gender: String,
    val activityLevel: String
)

data class FoodItemDto(
    val name: String,
    val weight: Double
)

data class CalculateNutritionRequest(
    val foods: List<FoodItemDto>
)

data class CreateUserRequest(
    val name: String,
    val age: Int,
    val weight: Double,
    val height: Int,
    val gender: String?,
    val activityLevel: String?
)

data class SetUserGoalsRequest(
    val userId: String,
    val dailyCalories: Int,
    val macroPercentages: MacroPercentagesDto
)

data class MacroPercentagesDto(
    val protein: Double,
    val carbs: Double,
    val fat: Double
)

data class LogMealRequest(
    val userId: String,
    val mealName: String,
    val foods: List<FoodItemDto>,
    val notes: String?
)

data class SetReminderRequest(
    val userId: String,
    val mealTime: String,
    val message: String
)

data class ShareDietRequest(
    val userId: String,
    val nutritionistEmail: String,
    val permissionLevel: String,
    val expirationDays: Int?
)

data class AwardBadgeRequest(
    val userId: String,
    val badgeId: String
)