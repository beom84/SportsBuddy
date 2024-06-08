package com.example.sportsbuddy.myprofile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sportsbuddy.databinding.ActivityMyprofileBinding

class MyProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMyprofileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMyprofileBinding.inflate(layoutInflater)
        binding.cvMyprofile .setContent {
            MyProfileScreen()
        }
        setContentView(binding.root)
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, MyProfileActivity::class.java)
    }
}

