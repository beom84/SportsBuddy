package com.example.sportsbuddy.enroll_match

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.sportsbuddy.databinding.ActivityEnrollMatchBinding

class EnrollMatchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEnrollMatchBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEnrollMatchBinding.inflate(layoutInflater)
        binding.cvEnrollMatch.setContent {
            EnrollMatchScreen { match ->
                val resultIntent = Intent().apply {
                    putExtra("MATCH_RESULT", match)
                }
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }
        }
        setContentView(binding.root)
    }

    companion object {
        fun getIntent(context: Context) = Intent(context, EnrollMatchActivity::class.java)    }
}