package com.example.sportsbuddy.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sportsbuddy.R

@Preview
@Composable
fun LoginScreen() {

    var inputId by remember {
        mutableStateOf("")
    }
    var inputPassword by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Spacer(modifier = Modifier.height(157.dp))

        Icon(
            painter = painterResource(id = R.drawable.ic_login_logo), contentDescription = "logo",
            modifier = Modifier.size(width = 100.dp, height = 57.dp)
        )
        Spacer(modifier = Modifier.height(23.dp))
        Text(text = "SPORTS_BUDDY", fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
        Text(text = "Find your sportsmate!", fontSize = 13.sp)
        Spacer(modifier = Modifier.height(84.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 50.dp)) {
            Column {
                TextField(
                    value = inputId,
                    onValueChange = { inputId = it },
                    modifier = Modifier.size(width = 160.dp, height = 40.dp)
                )
                TextField(
                    value = inputPassword,
                    onValueChange = { inputPassword = it },
                    modifier = Modifier.size(width = 160.dp, height = 40.dp)
                )
            }
            Spacer(modifier = Modifier.width(20.dp))

            Column {
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "로그인")
                }
                Text(text = "회원가입")
            }
        }


    }
}