package com.example.testapplication.domain.model

data class Character(
    val id: Int,
    val name: String,
    val image: String,
    val gender: String,
    var liked: Boolean = false,
)
