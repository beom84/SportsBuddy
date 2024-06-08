package com.example.sportsbuddy.message

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.sportsbuddy.R
import com.example.sportsbuddy.databinding.ActivityMatchDetailBinding
import com.example.sportsbuddy.databinding.ActivityMessageDetailBinding
import com.example.sportsbuddy.match.Match

class MessageDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMessageDetailBinding
    private var message: Message? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMessageDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        this.window?.apply {
            this.statusBarColor = getColor(R.color.grey_background)
        }
    }

    companion object {
        fun getIntent(context: Context, message: Message) = Intent(context, MessageDetailActivity::class.java).apply {
        }
    }
}