package com.example.sportsbuddy.login

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sportsbuddy.MainActivity
import com.example.sportsbuddy.R
import com.example.sportsbuddy.match.list.MatchListFragment


@Preview
@Composable
fun LoginScreen() {
    var inputId by remember { mutableStateOf(TextFieldValue("")) }
    var inputPassword by remember { mutableStateOf(TextFieldValue("")) }

    val context = LocalContext.current

    val id = "hci"
    val password = "1234"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background_black)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(157.dp))

        Image(
            painter = painterResource(id = R.drawable.ic_login_logo), contentDescription = "logo",
            modifier = Modifier.size(width = 100.dp, height = 57.dp)
        )
        Spacer(modifier = Modifier.height(23.dp))
        Text(
            text = "SPORTS_BUDDY",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            color = Color.White
        )
        Text(text = "Find your sportsmate!", fontSize = 13.sp, color = Color.White)
        Spacer(modifier = Modifier.height(80.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 50.dp), horizontalArrangement = Arrangement.Center
        ) {

            Column {
                CustomTextField(
                    value = inputId,
                    onValueChange = { inputId = it },
                    placeholder = "아이디",
                    modifier = Modifier.size(width = 160.dp, height = 44.dp)
                )
                Spacer(modifier = Modifier.height(8.dp)) // Add space between the text fields
                CustomTextField(
                    value = inputPassword,
                    onValueChange = { inputPassword = it },
                    placeholder = "비밀번호",
                    modifier = Modifier.size(width = 160.dp, height = 44.dp),
                    visualTransformation = PasswordVisualTransformation()
                )
            }
            Spacer(modifier = Modifier.width(20.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Spacer(modifier = Modifier.height(10.dp))
                Button(
                    onClick = {
                        if (inputId.annotatedString.text == id && inputPassword.annotatedString.text == password) {
                            Toast.makeText(context, "로그인 성공", Toast.LENGTH_SHORT).show()
                            context.startActivity(MainActivity.getIntent(context))
                        } else {
                            Toast.makeText(context, "아이디/비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()
                        }
                    },
                    modifier = Modifier
                        .size(width = 87.dp, height = 80.dp)
                        .background(color = Color(0xFF45B5AA), shape = RoundedCornerShape(10.dp)),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF45B5AA))
                ) {
                    Text(
                        text = "로그인",
                        fontSize = 14.sp,
                    )
                }

                Spacer(modifier = Modifier.height(5.dp))
                Text(text = "회원가입", color = colorResource(id = R.color.grayA5))
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
    Column {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            modifier = modifier,
            visualTransformation = visualTransformation,
            textStyle = TextStyle(
                color = Color.White,
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
                                color = Color.White,
                                fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                                fontWeight = FontWeight.Normal
                            )
                        )
                    }
                    innerTextField() // This is the actual input text
                }
            }
        )
        Divider(
            color = colorResource(id = R.color.line_gray),
            thickness = 1.dp,
            modifier = Modifier.width(160.dp)
        ) // Add a white divider
    }
}
