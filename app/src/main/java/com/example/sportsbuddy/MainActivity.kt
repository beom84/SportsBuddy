package com.example.sportsbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.sportsbuddy.screen.MainScreen
import com.example.sportsbuddy.ui.theme.SportsBuddyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SportsBuddyTheme {
                MainScreen()
            }
        }
    }
}

