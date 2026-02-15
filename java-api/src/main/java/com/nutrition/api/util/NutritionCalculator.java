package com.nutrition.api.util;

import com.nutrition.api.constants.FoodDatabase;
import com.nutrition.api.dto.*;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class NutritionCalculator {

    public static final Map<String, Double> ACTIVITY_MULTIPLIERS = new HashMap<String, Double>() {{
        put("sedentary", 1.2);
        put("light", 1.375);
        put("moderate", 1.55);
        put("active", 1.725);
        put("very_active", 1.9);
    }};

    public double calculateBmr(double weightKg, double heightCm, int age, String gender) {
        if (gender.toLowerCase().equals("male")) {
            return Math.round((88.362 + (13.397 * weightKg) + (4.799 * heightCm) - (5.677 * age)) * 100.0) / 100.0;
        } else {
            return Math.round((447.593 + (9.247 * weightKg) + (3.098 * heightCm) - (4.330 * age)) * 100.0) / 100.0;
        }
    }

    public double calculateTdee(double bmr, String activityLevel) {
        Double multiplier = ACTIVITY_MULTIPLIERS.get(activityLevel.toLowerCase());
        if (multiplier == null) {
            multiplier = 1.55; // default
        }
        return Math.round((bmr * multiplier) * 100.0) / 100.0;
    }

    public NutritionInfoDto calculateNutrition(FoodDatabase.NutritionInfo foodData, double weight) {
        double factor = weight / 100.0;
        NutritionInfoDto result = new NutritionInfoDto();
        result.setCalorie(Math.round((foodData.calories * factor) * 100.0) / 100.0);
        result.setProteine_g(Math.round((foodData.protein * factor) * 100.0) / 100.0);
        result.setCarboidrati_g(Math.round((foodData.carbs * factor) * 100.0) / 100.0);
        result.setGrassi_g(Math.round((foodData.fat * factor) * 100.0) / 100.0);
        if (foodData.fiber != null) {
            result.setFibre_g(Math.round((foodData.fiber * factor) * 100.0) / 100.0);
        }
        return result;
    }

    public NutritionSummaryDto calculateTotalNutrition(List<RequestDtos.FoodItemDto> foods) {
        double totalCalories = 0.0;
        double totalProtein = 0.0;
        double totalCarbs = 0.0;
        double totalFat = 0.0;
        double totalFiber = 0.0;

        for (RequestDtos.FoodItemDto foodItem : foods) {
            FoodDatabase.NutritionInfo nutritionInfo = FoodDatabase.FOOD_DATABASE.get(foodItem.getName().toLowerCase());
            if (nutritionInfo != null) {
                double factor = foodItem.getWeight() / 100.0;
                totalCalories += nutritionInfo.calories * factor;
                totalProtein += nutritionInfo.protein * factor;
                totalCarbs += nutritionInfo.carbs * factor;
                totalFat += nutritionInfo.fat * factor;
                if (nutritionInfo.fiber != null) {
                    totalFiber += nutritionInfo.fiber * factor;
                }
            }
        }

        NutritionSummaryDto result = new NutritionSummaryDto();
        result.setCalorieTotali(Math.round(totalCalories * 100.0) / 100.0);
        result.setProteineTotaliG(Math.round(totalProtein * 100.0) / 100.0);
        result.setCarboidratiTotaliG(Math.round(totalCarbs * 100.0) / 100.0);
        result.setGrassiTotaliG(Math.round(totalFat * 100.0) / 100.0);
        result.setFibreTotaliG(Math.round(totalFiber * 100.0) / 100.0);

        return result;
    }
}