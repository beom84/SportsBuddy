package com.example.sportsbuddy.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SampleScreen() {
    Column (modifier = Modifier.fillMaxWidth()){
        Text(text = "Sample Screen")
    }
}