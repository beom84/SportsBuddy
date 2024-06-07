package com.example.sportsbuddy.myprofile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

import com.example.sportsbuddy.databinding.ActivityLoginBinding

class MyProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        binding.cvLogin .setContent {
            MyProfileScreen()
        }
        setContentView(binding.root)
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, MyProfileActivity::class.java)
    }
}

