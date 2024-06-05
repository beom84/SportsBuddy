package com.example.sportsbuddy.match

data class Match(
    val title: String,
    val type: String,
    val maxCount: Int,
    val curCount: Int,
    val area: String,
    val userName: String,
    val userAge: Int,
    val userGender: String
)
