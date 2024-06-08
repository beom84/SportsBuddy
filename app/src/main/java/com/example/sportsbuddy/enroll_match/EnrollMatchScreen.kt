package com.example.sportsbuddy.enroll_match


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
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
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sportsbuddy.R
import com.example.sportsbuddy.enroll_match.spinner.AbilitiesSpinner
import com.example.sportsbuddy.enroll_match.spinner.District
import com.example.sportsbuddy.enroll_match.spinner.LocationSpinner
import com.example.sportsbuddy.enroll_match.spinner.Neighborhood
import com.example.sportsbuddy.enroll_match.spinner.Sport
import com.example.sportsbuddy.enroll_match.spinner.SportsAbility
import com.example.sportsbuddy.enroll_match.spinner.SportsSpinner
import com.example.sportsbuddy.enroll_match.spinner.abilities
import com.example.sportsbuddy.enroll_match.spinner.districts
import com.example.sportsbuddy.enroll_match.spinner.sports
import com.example.sportsbuddy.match.Match

@Composable
fun EnrollMatchScreen(onMatchEnroll: (Match) -> Unit) {

    var title by remember { mutableStateOf("") }
    var selectedDistrict by remember { mutableStateOf<District?>(null) }
    var selectedNeighborhood by remember { mutableStateOf<Neighborhood?>(null) }
    var selectedAbility by remember { mutableStateOf<SportsAbility?>(null) }
    var selectedSport by remember { mutableStateOf<Sport?>(null) }
    var time by remember { mutableStateOf("") }
    var maxParticipants by remember { mutableStateOf<Int>(10) }
    var description by remember { mutableStateOf("") }

    val focusManager = LocalFocusManager.current


    Column(
        modifier = Modifier
            .background(Color(0x222222))
            .fillMaxSize()
    ) {
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
                    SportsSpinner(
                        sports = sports,
                        selectedSport = selectedSport,
                        onSportSelected = { selectedSport = it }
                    )
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

                    AbilitiesSpinner(
                        abilities = abilities,
                        selectedAbility = selectedAbility,
                        onAbilitySelected = { selectedAbility = it }
                    )
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
                    LocationSpinner(
                        districts = districts,
                        selectedDistrict = selectedDistrict,
                        onDistrictSelected = { selectedDistrict = it },
                        selectedNeighborhood = selectedNeighborhood,
                        onNeighborhoodSelected = { selectedNeighborhood = it }
                    )
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
                        placeholder = { Text("주로 평일 밤에 운동합니다!", color = Color(0xFF8E8E8E)) },
                        colors = TextFieldDefaults.textFieldColors(
                            backgroundColor = Color(0xFF2F2F2F),
                            textColor = Color(0xFF8E8E8E)
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
                    maxLines = 15,
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                        }
                    )

                )

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
        Box(
            modifier = Modifier
                .background(colorResource(id = R.color.basic_background))
                .fillMaxSize()

        ) {
            Button(
                onClick = {
                    val newMatch = Match(
                        title = title,
                        type = selectedSport?.name ?: "",
                        curCount = 0,  // Assuming curCount is initially 0
                        maxCount = maxParticipants,
                        area = "${selectedDistrict?.name} ${selectedNeighborhood?.name}",
                        userName = "최민규카츠",  // Replace with actual user data
                        userAge = 22,  // Replace with actual user data
                        userGender = "남",  // Replace with actual user data
                        userLevel = selectedAbility?.name ?: "",
                        time = time,
                        content = description,
                        thumbnail = R.drawable.basic_profile_img  // Replace with actual resource
                    )
                    onMatchEnroll(newMatch)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, end = 20.dp, bottom = 28.dp)
                    .height(50.dp),
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
}

//@Preview
//@Composable
//private fun EnrollMatchScreenPreview() {
//    EnrollMatchScreen()
//}




