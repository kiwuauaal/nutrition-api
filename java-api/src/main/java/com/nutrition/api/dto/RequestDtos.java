package com.nutrition.api.dto;

import java.util.List;

// Request DTOs
public class RequestDtos {
    
    public static class CalculateBmrRequest {
        private double weight;
        private double height;
        private int age;
        private String gender;
        private String activityLevel;

        // Getters and setters
        public double getWeight() { return weight; }
        public void setWeight(double weight) { this.weight = weight; }
        public double getHeight() { return height; }
        public void setHeight(double height) { this.height = height; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
        public String getGender() { return gender; }
        public void setGender(String gender) { this.gender = gender; }
        public String getActivityLevel() { return activityLevel; }
        public void setActivityLevel(String activityLevel) { this.activityLevel = activityLevel; }
    }

    public static class FoodItemDto {
        private String name;
        private double weight;

        // Getters and setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public double getWeight() { return weight; }
        public void setWeight(double weight) { this.weight = weight; }
    }

    public static class CalculateNutritionRequest {
        private List<FoodItemDto> foods;

        // Getters and setters
        public List<FoodItemDto> getFoods() { return foods; }
        public void setFoods(List<FoodItemDto> foods) { this.foods = foods; }
    }

    public static class CreateUserRequest {
        private String name;
        private int age;
        private double weight;
        private int height;
        private String gender;
        private String activityLevel;

        // Getters and setters
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
        public double getWeight() { return weight; }
        public void setWeight(double weight) { this.weight = weight; }
        public int getHeight() { return height; }
        public void setHeight(int height) { this.height = height; }
        public String getGender() { return gender; }
        public void setGender(String gender) { this.gender = gender; }
        public String getActivityLevel() { return activityLevel; }
        public void setActivityLevel(String activityLevel) { this.activityLevel = activityLevel; }
    }

    public static class SetUserGoalsRequest {
        private String userId;
        private int dailyCalories;
        private MacroPercentagesDto macroPercentages;

        // Getters and setters
        public String getUserId() { return userId; }
        public void setUserId(String userId) { this.userId = userId; }
        public int getDailyCalories() { return dailyCalories; }
        public void setDailyCalories(int dailyCalories) { this.dailyCalories = dailyCalories; }
        public MacroPercentagesDto getMacroPercentages() { return macroPercentages; }
        public void setMacroPercentages(MacroPercentagesDto macroPercentages) { this.macroPercentages = macroPercentages; }
    }

    public static class MacroPercentagesDto {
        private double protein;
        private double carbs;
        private double fat;

        // Getters and setters
        public double getProtein() { return protein; }
        public void setProtein(double protein) { this.protein = protein; }
        public double getCarbs() { return carbs; }
        public void setCarbs(double carbs) { this.carbs = carbs; }
        public double getFat() { return fat; }
        public void setFat(double fat) { this.fat = fat; }
    }

    public static class LogMealRequest {
        private String userId;
        private String mealName;
        private List<FoodItemDto> foods;
        private String notes;

        // Getters and setters
        public String getUserId() { return userId; }
        public void setUserId(String userId) { this.userId = userId; }
        public String getMealName() { return mealName; }
        public void setMealName(String mealName) { this.mealName = mealName; }
        public List<FoodItemDto> getFoods() { return foods; }
        public void setFoods(List<FoodItemDto> foods) { this.foods = foods; }
        public String getNotes() { return notes; }
        public void setNotes(String notes) { this.notes = notes; }
    }

    public static class SetReminderRequest {
        private String userId;
        private String mealTime;
        private String message;

        // Getters and setters
        public String getUserId() { return userId; }
        public void setUserId(String userId) { this.userId = userId; }
        public String getMealTime() { return mealTime; }
        public void setMealTime(String mealTime) { this.mealTime = mealTime; }
        public String getMessage() { return message; }
        public void setMessage(String message) { this.message = message; }
    }

    public static class ShareDietRequest {
        private String userId;
        private String nutritionistEmail;
        private String permissionLevel;
        private Integer expirationDays;

        // Getters and setters
        public String getUserId() { return userId; }
        public void setUserId(String userId) { this.userId = userId; }
        public String getNutritionistEmail() { return nutritionistEmail; }
        public void setNutritionistEmail(String nutritionistEmail) { this.nutritionistEmail = nutritionistEmail; }
        public String getPermissionLevel() { return permissionLevel; }
        public void setPermissionLevel(String permissionLevel) { this.permissionLevel = permissionLevel; }
        public Integer getExpirationDays() { return expirationDays; }
        public void setExpirationDays(Integer expirationDays) { this.expirationDays = expirationDays; }
    }

    public static class AwardBadgeRequest {
        private String userId;
        private String badgeId;

        // Getters and setters
        public String getUserId() { return userId; }
        public void setUserId(String userId) { this.userId = userId; }
        public String getBadgeId() { return badgeId; }
        public void setBadgeId(String badgeId) { this.badgeId = badgeId; }
    }

    // Response DTOs
    public static class CalculateNutritionResponse {
        private NutritionSummaryDto riepilogoNutrizionale;

        // Getters and setters
        public NutritionSummaryDto getRiepilogoNutrizionale() { return riepilogoNutrizionale; }
        public void setRiepilogoNutrizionale(NutritionSummaryDto riepilogoNutrizionale) { this.riepilogoNutrizionale = riepilogoNutrizionale; }
    }

    public static class NutritionSummaryDto {
        private double calorieTotali;
        private double proteineTotaliG;
        private double carboidratiTotaliG;
        private double grassiTotaliG;
        private double fibreTotaliG;

        // Getters and setters
        public double getCalorieTotali() { return calorieTotali; }
        public void setCalorieTotali(double calorieTotali) { this.calorieTotali = calorieTotali; }
        public double getProteineTotaliG() { return proteineTotaliG; }
        public void setProteineTotaliG(double proteineTotaliG) { this.proteineTotaliG = proteineTotaliG; }
        public double getCarboidratiTotaliG() { return carboidratiTotaliG; }
        public void setCarboidratiTotaliG(double carboidratiTotaliG) { this.carboidratiTotaliG = carboidratiTotaliG; }
        public double getGrassiTotaliG() { return grassiTotaliG; }
        public void setGrassiTotaliG(double grassiTotaliG) { this.grassiTotaliG = grassiTotaliG; }
        public double getFibreTotaliG() { return fibreTotaliG; }
        public void setFibreTotaliG(double fibreTotaliG) { this.fibreTotaliG = fibreTotaliG; }
    }

    public static class UserResponse {
        private String id;
        private String email;
        private String name;
        private int age;
        private double weight;
        private int height;
        private String gender;
        private String activityLevel;

        // Getters and setters
        public String getId() { return id; }
        public void setId(String id) { this.id = id; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
        public int getAge() { return age; }
        public void setAge(int age) { this.age = age; }
        public double getWeight() { return weight; }
        public void setWeight(double weight) { this.weight = weight; }
        public int getHeight() { return height; }
        public void setHeight(int height) { this.height = height; }
        public String getGender() { return gender; }
        public void setGender(String gender) { this.gender = gender; }
        public String getActivityLevel() { return activityLevel; }
        public void setActivityLevel(String activityLevel) { this.activityLevel = activityLevel; }
    }

    public static class CreateUserResponse {
        private String userId;
        private UserResponse userData;

        // Getters and setters
        public String getUserId() { return userId; }
        public void setUserId(String userId) { this.userId = userId; }
        public UserResponse getUserData() { return userData; }
        public void setUserData(UserResponse userData) { this.userData = userData; }
    }

    public static class NutritionInfoDto {
        private double calorie;
        private double proteine_g;
        private double carboidrati_g;
        private double grassi_g;
        private Double fibre_g;

        // Getters and setters
        public double getCalorie() { return calorie; }
        public void setCalorie(double calorie) { this.calorie = calorie; }
        public double getProteine_g() { return proteine_g; }
        public void setProteine_g(double proteine_g) { this.proteine_g = proteine_g; }
        public double getCarboidrati_g() { return carboidrati_g; }
        public void setCarboidrati_g(double carboidrati_g) { this.carboidrati_g = carboidrati_g; }
        public double getGrassi_g() { return grassi_g; }
        public void setGrassi_g(double grassi_g) { this.grassi_g = grassi_g; }
        public Double getFibre_g() { return fibre_g; }
        public void setFibre_g(Double fibre_g) { this.fibre_g = fibre_g; }
    }

    public static class ApiResponse<T> {
        private boolean success;
        private T data;
        private String error;

        public ApiResponse(boolean success, T data, String error) {
            this.success = success;
            this.data = data;
            this.error = error;
        }

        // Getters and setters
        public boolean isSuccess() { return success; }
        public void setSuccess(boolean success) { this.success = success; }
        public T getData() { return data; }
        public void setData(T data) { this.data = data; }
        public String getError() { return error; }
        public void setError(String error) { this.error = error; }
    }
}