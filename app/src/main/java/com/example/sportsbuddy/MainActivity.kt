package com.example.sportsbuddy

import android.os.Bundle

import androidx.appcompat.app.AppCompatActivity
import com.example.sportsbuddy.databinding.ActivityMainBinding
import com.example.sportsbuddy.login.LoginActivity


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            SportsBuddyTheme {
//                MainScreen()
//            }
//        }
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initListener()
    }

    private fun initListener() {
        with(binding) {
            tvMain.setOnClickListener {
                startActivity(LoginActivity.getIntent(this@MainActivity))
            }
        }
    }
}

