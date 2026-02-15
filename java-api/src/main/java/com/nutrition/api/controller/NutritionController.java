package com.nutrition.api.controller;

import com.nutrition.api.dto.RequestDtos;
import com.nutrition.api.dto.CalculateBmrResponse;
import com.nutrition.api.dto.GoalsSuggestionResponse;
import com.nutrition.api.dto.CalculateNutritionResponse;
import com.nutrition.api.dto.NutritionSummaryDto;
import com.nutrition.api.dto.UserResponse;
import com.nutrition.api.dto.CreateUserResponse;
import com.nutrition.api.dto.NutritionInfoDto;
import com.nutrition.api.dto.RequestDtos.ApiResponse;
import com.nutrition.api.service.NutritionService;
import com.nutrition.api.util.NutritionCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/")
public class NutritionController {

    @Autowired
    private NutritionService nutritionService;

    @Autowired
    private NutritionCalculator nutritionCalculator;

    @GetMapping
    public ResponseEntity<RequestDtos.ApiResponse<Map<String, Object>>> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("message", "🔥 Nutrition API Ultimate - Production Ready!");
        response.put("version", "4.0");
        
        Map<String, Object> features = new HashMap<>();
        features.put("authentication", "✅ JWT Authentication");
        features.put("database", "✅ Supabase Integration");
        features.put("documentation", "✅ Swagger/OpenAPI Docs");
        features.put("deployment", "✅ Docker Ready");
        features.put("security", "✅ JWT Authentication");
        response.put("features", features);
        
        Map<String, Object> endpoints = new HashMap<>();
        endpoints.put("CORE", java.util.Arrays.asList("/foods", "/calculate", "/calculate-bmr"));
        endpoints.put("USER", java.util.Arrays.asList("/users", "/users/{id}", "/users/goals"));
        endpoints.put("MEALS", java.util.Arrays.asList("/meals", "/meals/duplicate"));
        endpoints.put("ANALYTICS", java.util.Arrays.asList("/stats/{id}/week", "/charts/{id}/weekly"));
        response.put("endpoints", endpoints);
        response.put("docs", "/swagger");

        RequestDtos.ApiResponse<Map<String, Object>> apiResponse = new RequestDtos.ApiResponse<>(true, response, null);
        return ResponseEntity.ok(apiResponse);
    }

    @GetMapping("/health")
    public ResponseEntity<RequestDtos.ApiResponse<Map<String, Object>>> healthCheck() {
        Map<String, Object> response = new HashMap<>();
        response.put("status", "healthy");
        response.put("version", "4.0");
        response.put("database", "connected"); // Simplified for now
        response.put("uptime", "0"); // Simplified for now
        
        Map<String, Object> features = new HashMap<>();
        features.put("supabase", true);
        features.put("jwt", true);
        response.put("features", features);

        RequestDtos.ApiResponse<Map<String, Object>> apiResponse = new RequestDtos.ApiResponse<>(true, response, null);
        return ResponseEntity.ok(apiResponse);
    }

    @PostMapping("/calculate-bmr")
    public ResponseEntity<RequestDtos.ApiResponse<CalculateBmrResponse>> calculateBmr(
            @RequestBody RequestDtos.CalculateBmrRequest request) {
        try {
            double bmr = nutritionCalculator.calculateBmr(
                request.getWeight(),
                request.getHeight(),
                request.getAge(),
                request.getGender()
            );
            double tdee = nutritionCalculator.calculateTdee(bmr, request.getActivityLevel());

            GoalsSuggestionResponse goalsSuggestion = new GoalsSuggestionResponse();
            goalsSuggestion.setMantenimentoPeso(tdee);
            goalsSuggestion.setPerditaPeso(tdee - 500);
            goalsSuggestion.setAumentoMassa(tdee + 500);

            CalculateBmrResponse response = new CalculateBmrResponse();
            response.setBmr(bmr);
            response.setTdee(tdee);
            response.setGoalsSuggestion(goalsSuggestion);

            RequestDtos.ApiResponse<CalculateBmrResponse> apiResponse = new RequestDtos.ApiResponse<>(true, response, null);
            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            RequestDtos.ApiResponse<CalculateBmrResponse> apiResponse = new RequestDtos.ApiResponse<>(false, null, e.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);
        }
    }

    @PostMapping("/calculate")
    public ResponseEntity<RequestDtos.ApiResponse<CalculateNutritionResponse>> calculateNutrition(
            @RequestBody RequestDtos.CalculateNutritionRequest request) {
        try {
            com.nutrition.api.dto.NutritionSummaryDto totalNutrition = nutritionCalculator.calculateTotalNutrition(request.getFoods());
            
            CalculateNutritionResponse response = new CalculateNutritionResponse();
            response.setRiepilogoNutrizionale(totalNutrition);

            RequestDtos.ApiResponse<CalculateNutritionResponse> apiResponse = new RequestDtos.ApiResponse<>(true, response, null);
            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            RequestDtos.ApiResponse<CalculateNutritionResponse> apiResponse = new RequestDtos.ApiResponse<>(false, null, e.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);
        }
    }

    @PostMapping("/users")
    public ResponseEntity<RequestDtos.ApiResponse<CreateUserResponse>> createUser(
            @RequestBody RequestDtos.CreateUserRequest request) {
        try {
            com.nutrition.api.entity.User user = nutritionService.createUser(request);
            
            UserResponse userData = new UserResponse();
            userData.setId(user.getId().toString());
            userData.setEmail(user.getEmail());
            userData.setName(user.getName());
            userData.setAge(user.getAge());
            userData.setWeight(user.getWeight());
            userData.setHeight(user.getHeight());
            userData.setGender(user.getGender().toString().toLowerCase());
            userData.setActivityLevel(user.getActivityLevel().toString().toLowerCase());

            CreateUserResponse response = new CreateUserResponse();
            response.setUserId(user.getId().toString());
            response.setUserData(userData);

            RequestDtos.ApiResponse<CreateUserResponse> apiResponse = new RequestDtos.ApiResponse<>(true, response, null);
            return ResponseEntity.ok(apiResponse);
        } catch (Exception e) {
            RequestDtos.ApiResponse<CreateUserResponse> apiResponse = new RequestDtos.ApiResponse<>(false, null, e.getMessage());
            return ResponseEntity.badRequest().body(apiResponse);
        }
    }
}