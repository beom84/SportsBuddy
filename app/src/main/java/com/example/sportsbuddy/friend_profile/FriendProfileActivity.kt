package com.example.sportsbuddy.friend_profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sportsbuddy.databinding.ActivityFriendProfileBinding
import com.example.sportsbuddy.enroll_match.EnrollMatchActivity
import com.example.sportsbuddy.enroll_match.EnrollMatchScreen

class FriendProfileActivity: AppCompatActivity()  {

    private lateinit var binding: ActivityFriendProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityFriendProfileBinding.inflate(layoutInflater)
        binding.cvEnrollMatch.setContent {
            FriendProfileScreen()
        }
        setContentView(binding.root)
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, EnrollMatchActivity::class.java)
    }
}