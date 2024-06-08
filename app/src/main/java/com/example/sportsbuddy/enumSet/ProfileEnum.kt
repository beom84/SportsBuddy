package com.example.sportsbuddy.enumSet

import com.example.sportsbuddy.R

enum class ProfileEnum(val userName: String, val age: Int, val gender: String, val thumbnail: Int) {
    User1("최민규카츠", 22, "남자", R.drawable.img_profile_1),
    User2("안녕", 22, "남자", R.drawable.img_profile_2),
    User3("이름", 22, "남자", R.drawable.img_profile_3),
    User4("안뇽", 22, "여자", R.drawable.img_profile_4),
    User5("사람", 22, "여자", R.drawable.img_profile_5)
}