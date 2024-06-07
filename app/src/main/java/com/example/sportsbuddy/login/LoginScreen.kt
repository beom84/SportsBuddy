package com.example.sportsbuddy.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sportsbuddy.R

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun LoginScreen() {
    var inputId by remember { mutableStateOf(TextFieldValue("")) }
    var inputPassword by remember { mutableStateOf(TextFieldValue("")) }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
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
            .padding(horizontal = 50.dp), horizontalArrangement = Arrangement.Center) {

            Column {
                CustomTextField(
                    value = inputId,
                    onValueChange = { inputId = it },
                    placeholder = "아이디",
                    modifier = Modifier.size(width = 160.dp, height = 50.dp)
                )
                Spacer(modifier = Modifier.height(8.dp)) // Add space between the text fields
                CustomTextField(
                    value = inputPassword,
                    onValueChange = { inputPassword = it },
                    placeholder = "비밀번호",
                    modifier = Modifier.size(width = 160.dp, height = 50.dp),
                    visualTransformation = PasswordVisualTransformation()
                )
            }
            Spacer(modifier = Modifier.width(20.dp))

            Column (horizontalAlignment = Alignment.CenterHorizontally){
                Button(onClick = { /*TODO*/ }, modifier = Modifier.size(width = 87.dp, height = 73.dp)) {
                    Text(text = "로그인", fontSize = 14.sp)
                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "회원가입")
            }
        }


    }
}

@Composable
fun CustomTextField(
    value: TextFieldValue,
    onValueChange: (TextFieldValue) -> Unit,
    placeholder: String,
    modifier: Modifier = Modifier,
    visualTransformation: VisualTransformation = VisualTransformation.None
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChange,
        modifier = modifier,
        visualTransformation = visualTransformation,
        textStyle = TextStyle(
            color = Color.Black,
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = FontWeight.Normal,
            textAlign = TextAlign.Start
        ),
        decorationBox = { innerTextField ->
            Box(
                modifier = Modifier
                    .background(Color.Transparent)
                    .padding(horizontal = 4.dp, vertical = 12.dp)
            ) {
                if (value.text.isEmpty()) {
                    Text(
                        text = placeholder,
                        style = TextStyle(
                            color = Color.Gray,
                            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                            fontWeight = FontWeight.Normal
                        )
                    )
                }
                innerTextField() // This is the actual input text
            }
        }
    )
}