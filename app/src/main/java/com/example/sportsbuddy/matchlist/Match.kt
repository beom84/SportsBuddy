package com.example.sportsbuddy.matchlist

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
