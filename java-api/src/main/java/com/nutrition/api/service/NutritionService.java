package com.nutrition.api.service;

import com.nutrition.api.dto.RequestDtos;
import com.nutrition.api.entity.User;
import com.nutrition.api.entity.Gender;
import com.nutrition.api.entity.ActivityLevel;
import com.nutrition.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.UUID;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;

@Service
public class NutritionService {

    @Autowired
    private UserRepository userRepository;
    
    @Autowired(required=false)
    private OkHttpClient httpClient;
    
    @Autowired(required=false)
    private ObjectMapper objectMapper;
    
    @Value("${supabase.url:}")
    private String supabaseUrl;
    
    @Value("${supabase.key:}")
    private String supabaseKey;

    public User createUser(RequestDtos.CreateUserRequest request) {
        User user = new User();
        user.setEmail(request.getName().toLowerCase().replace(" ", "") + "@example.com"); // Better email generation
        user.setName(request.getName());
        user.setAge(request.getAge());
        user.setWeight(request.getWeight());
        user.setHeight(request.getHeight());
        user.setGender(parseGender(request.getGender()));
        user.setActivityLevel(parseActivityLevel(request.getActivityLevel()));
        
        // Try to save to Supabase if available, otherwise use local DB
        if (httpClient != null && supabaseUrl != null && !supabaseUrl.isEmpty() && supabaseKey != null && !supabaseKey.isEmpty()) {
            try {
                Map<String, Object> userData = new HashMap<>();
                userData.put("email", user.getEmail());
                userData.put("name", user.getName());
                userData.put("age", user.getAge());
                userData.put("weight", user.getWeight());
                userData.put("height", user.getHeight());
                userData.put("gender", user.getGender().toString());
                userData.put("activity_level", user.getActivityLevel().toString());
                
                // Save to Supabase using HTTP client
                String json = objectMapper.writeValueAsString(userData);
                RequestBody body = RequestBody.create(json, okhttp3.MediaType.get("application/json"));
                
                Request supabaseRequest = new Request.Builder()
                    .url(supabaseUrl + "/rest/v1/users")
                    .post(body)
                    .addHeader("apikey", supabaseKey)
                    .addHeader("Authorization", "Bearer " + supabaseKey)
                    .addHeader("Content-Type", "application/json")
                    .build();
                
                try (Response response = httpClient.newCall(supabaseRequest).execute()) {
                    if (!response.isSuccessful()) {
                        // Fallback to local repository if Supabase fails
                        return userRepository.save(user);
                    }
                }
            } catch (Exception e) {
                // Fallback to local repository if Supabase fails
                return userRepository.save(user);
            }
        }
        
        return userRepository.save(user);
    }

    private Gender parseGender(String genderStr) {
        if (genderStr == null) {
            return Gender.OTHER;
        }
        switch (genderStr.toUpperCase()) {
            case "MALE":
                return Gender.MALE;
            case "FEMALE":
                return Gender.FEMALE;
            default:
                return Gender.OTHER;
        }
    }

    private ActivityLevel parseActivityLevel(String levelStr) {
        if (levelStr == null) {
            return ActivityLevel.MODERATE;
        }
        switch (levelStr.toUpperCase()) {
            case "SEDENTARY":
                return ActivityLevel.SEDENTARY;
            case "LIGHT":
                return ActivityLevel.LIGHT;
            case "MODERATE":
                return ActivityLevel.MODERATE;
            case "ACTIVE":
                return ActivityLevel.ACTIVE;
            case "VERY_ACTIVE":
                return ActivityLevel.VERY_ACTIVE;
            default:
                return ActivityLevel.MODERATE;
        }
    }
}