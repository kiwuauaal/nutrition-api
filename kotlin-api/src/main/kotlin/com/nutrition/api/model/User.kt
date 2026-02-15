package com.nutrition.api.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(unique = true)
    val email: String,

    val name: String,

    val age: Int,

    val weight: Double,

    val height: Int,

    @Enumerated(EnumType.STRING)
    val gender: Gender,

    @Enumerated(EnumType.STRING)
    val activityLevel: ActivityLevel,

    val createdAt: LocalDateTime = LocalDateTime.now(),

    val updatedAt: LocalDateTime = LocalDateTime.now()
)

enum class Gender {
    MALE, FEMALE, OTHER
}

enum class ActivityLevel {
    SEDENTARY, LIGHT, MODERATE, ACTIVE, VERY_ACTIVE
}