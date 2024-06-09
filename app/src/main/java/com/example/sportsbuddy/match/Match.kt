package com.example.sportsbuddy.match

data class Match(
    val title: String,
    val type: String,
    val curCount: Int,
    val maxCount: Int,
    val area: String,
    val userName: String,
    val userAge: Int,
    val userGender: String,
    val userLevel: String,
    val time: String,
    val content: String,
    val thumbnail: Int
) : java.io.Serializable
