package com.nutrition.api.service

import com.nutrition.api.dto.CreateUserRequest
import com.nutrition.api.model.User
import com.nutrition.api.repository.UserRepository
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import com.fasterxml.jackson.databind.ObjectMapper
import java.util.*

@Service
class NutritionService {

    @Autowired
    private lateinit var userRepository: UserRepository
    
    @Autowired(required = false)
    private lateinit var httpClient: OkHttpClient
    
    @Autowired(required = false)
    private lateinit var objectMapper: ObjectMapper
    
    @Value("\${supabase.url:}")
    private lateinit var supabaseUrl: String
    
    @Value("\${supabase.key:}")
    private lateinit var supabaseKey: String

    fun createUser(request: CreateUserRequest): User {
        val user = User(
            email = request.name.lowercase().replace(" ", "") + "@example.com", // Better email generation
            name = request.name,
            age = request.age,
            weight = request.weight,
            height = request.height,
            gender = parseGender(request.gender ?: "OTHER"),
            activityLevel = parseActivityLevel(request.activityLevel ?: "MODERATE")
        )
        
        // Try to save to Supabase if available, otherwise use local DB
        if (::httpClient.isInitialized && ::objectMapper.isInitialized && 
            ::supabaseUrl.isInitialized && supabaseUrl.isNotEmpty() &&
            ::supabaseKey.isInitialized && supabaseKey.isNotEmpty()) {
            
            try {
                val userData = mapOf(
                    "email" to user.email,
                    "name" to user.name,
                    "age" to user.age,
                    "weight" to user.weight,
                    "height" to user.height,
                    "gender" to user.gender.toString(),
                    "activity_level" to user.activityLevel.toString()
                )
                
                val json = objectMapper.writeValueAsString(userData)
                
                val supabaseRequest = Request.Builder()
                    .url("$supabaseUrl/rest/v1/users")
                    .post(json.toRequestBody(okhttp3.MediaType.get("application/json")))
                    .addHeader("apikey", supabaseKey)
                    .addHeader("Authorization", "Bearer $supabaseKey")
                    .addHeader("Content-Type", "application/json")
                    .build()
                
                httpClient.newCall(supabaseRequest).execute().use { response ->
                    if (!response.isSuccessful) {
                        // Fallback to local repository if Supabase fails
                        return userRepository.save(user)
                    }
                }
            } catch (e: Exception) {
                // Fallback to local repository if Supabase fails
                return userRepository.save(user)
            }
        }
        
        return userRepository.save(user)
    }

    private fun parseGender(genderStr: String): com.nutrition.api.model.Gender {
        return when (genderStr.uppercase()) {
            "MALE" -> com.nutrition.api.model.Gender.MALE
            "FEMALE" -> com.nutrition.api.model.Gender.FEMALE
            else -> com.nutrition.api.model.Gender.OTHER
        }
    }

    private fun parseActivityLevel(levelStr: String): com.nutrition.api.model.ActivityLevel {
        return when (levelStr.uppercase()) {
            "SEDENTARY" -> com.nutrition.api.model.ActivityLevel.SEDENTARY
            "LIGHT" -> com.nutrition.api.model.ActivityLevel.LIGHT
            "MODERATE" -> com.nutrition.api.model.ActivityLevel.MODERATE
            "ACTIVE" -> com.nutrition.api.model.ActivityLevel.ACTIVE
            "VERY_ACTIVE" -> com.nutrition.api.model.ActivityLevel.VERY_ACTIVE
            else -> com.nutrition.api.model.ActivityLevel.MODERATE
        }
    }
}