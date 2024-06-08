package com.example.sportsbuddy.enroll_match


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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.Button
import androidx.compose.material.TextField
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sportsbuddy.R
import com.example.sportsbuddy.enroll_match.spinner.DrawEditLocation
import com.example.sportsbuddy.enroll_match.spinner.DrawEditSports
import com.example.sportsbuddy.enroll_match.spinner.DrawEditSportsAbility
import com.example.sportsbuddy.enroll_match.spinner.LocationSpinner

@Composable
fun EnrollMatchScreen(modifier: Modifier = Modifier) {

    var title by remember { mutableStateOf("") }
    var time by remember { mutableStateOf("주로 평일 밤에 운동합니다!") }
    var maxParticipants by remember { mutableStateOf(20) }
    var description by remember { mutableStateOf("") }

    Column(modifier = Modifier.background(Color(0x222222))
        .fillMaxSize()) {
        TopAppBar(
            onBackIconClick = {},
            title = "매칭등록",
            titleColor = colorResource(R.color.white),
            onRightIconClick = { /*TODO*/ }, // 추후 마이페이지로 이동 가능하도록 구현
            rightIconImgId = null
        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .background(color = Color.White)
        )
        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.basic_background))
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(20.dp)
                    .background(Color(0xFF2F2F2F))
                    .fillMaxWidth()
                    .height(640.dp)
            ) {
                Row(
                    modifier = Modifier.padding(start = 16.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "제목",
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    TextField(
                        value = title,
                        onValueChange = { title = it },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 45.dp),
                        textStyle = TextStyle(Color.White),
                        placeholder = { Text("제목을 입력하세요", color = Color.White) },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(0xFF2F2F2F),
                            textColor = Color.White,
                            placeholderColor = Color.White
                        )
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = "운동 종목", color = Color.White, fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    DrawEditSports()
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = "운동 능력",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    DrawEditSportsAbility()
                }

                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp, end = 35.dp),
                        text = "장소",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    DrawEditLocation()
                }

                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = "시간",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    TextField(
                        value = time,
                        onValueChange = { time = it },
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(Color(0xFF8E8E8E)),
                        placeholder = { Text("시간을 입력하세요", color = Color(0xFF8E8E8E)) },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(0xFF2F2F2F),
                            textColor = Color(0xFF8E8E8E),
                            placeholderColor = Color(0xFF8E8E8E)
                        )
                    )
                }
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        modifier = Modifier.padding(start = 16.dp),
                        text = "모집 인원",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    TextField(
                        value = maxParticipants.toString(),
                        onValueChange = { maxParticipants = it.toIntOrNull() ?: 0 },
                        modifier = Modifier.fillMaxWidth(),
                        textStyle = TextStyle(Color(0xFF8E8E8E)),
                        placeholder = {
                            Text(
                                "모집인원을 입력하세요",
                                color = Color(0xFF8E8E8E),
                                fontSize = 16.sp
                            )
                        },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(0xFF2F2F2F),
                            textColor = Color(0xFF8E8E8E),
                            placeholderColor = Color(0xFF8E8E8E)
                        ),
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
                    )
                }

                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = "내용",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.ExtraBold
                )
                TextField(
                    value = description,
                    onValueChange = { description = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(300.dp),
                    textStyle = TextStyle(Color(0xFF8E8E8E)),
                    placeholder = { Text("내용을 입력하세요", color = Color(0xFF8E8E8E)) },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Color(0xFF2F2F2F),
                        textColor = Color(0xFF8E8E8E),
                        placeholderColor = Color(0xFF8E8E8E)
                    ),
                    maxLines = 15
                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        Button(
            onClick = { /* TODO: 등록하기 */ },
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp, bottom = 28.dp).height(50.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = colorResource(id = R.color.mint),
                containerColor = colorResource(id = R.color.mint)
            )
        ) {
            Text(
                "등록하기", color = Color.White, fontSize = 16.sp,
                fontWeight = FontWeight.ExtraBold
            )
        }
    }
}

@Preview
@Composable
private fun EnrollMatchScreenPreview() {
    EnrollMatchScreen()
}




