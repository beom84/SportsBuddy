package com.example.sportsbuddy.message

data class Message(
    val title: String,
    val time: String,
    val body: String,
    val userName: String,
    val userAge: Int,
    val userGender: String,
    val thumbnail: Int,
) : java.io.Serializable
