package com.example.sportsbuddy.sample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sportsbuddy.databinding.ActivitySampleBinding
import com.example.sportsbuddy.screen.SampleScreen

class SampleActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySampleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySampleBinding.inflate(layoutInflater)
        binding.cvSample.setContent {
            SampleScreen()
        }
        setContentView(binding.root)
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, SampleActivity::class.java)
    }
}