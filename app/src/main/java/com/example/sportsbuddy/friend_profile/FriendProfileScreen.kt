package com.example.sportsbuddy.friend_profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sportsbuddy.R
import com.example.sportsbuddy.enroll_match.TopAppBar

@Composable
fun FriendProfileScreen(modifier: Modifier = Modifier) {

    val list = listOf("농구", "야구", "볼링", "헬스")
    var description by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .background(
                colorResource(id = R.color.grey_background),
                shape = RoundedCornerShape(8.dp)
            )
            .fillMaxSize()
    ) {
        TopAppBar(
            onBackIconClick = {},
            title = "프로필",
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
        ProfileRow(
            imgid = R.drawable.basic_profile_img,
            nickname = "최민규카츠",
            gender = "남",
            age = "22",
            location = "광진구 화양동"
        )
        InterestGrid(list = list)
        Text(
            modifier = Modifier.padding(start = 40.dp, top = 34.dp, bottom = 6.dp),
            text = "자기 소개",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.ExtraBold
        )
        TextField(
            value = description,
            onValueChange = { description = it },
            modifier = Modifier
                .fillMaxWidth()
                .height(285.dp)
                .padding(start = 20.dp, end = 20.dp),
            textStyle = TextStyle(Color(0xFF8E8E8E)),
            placeholder = { Text("내용을 입력하세요", color = Color(0xFF8E8E8E)) },
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color(0xFF2F2F2F),
                textColor = Color(0xFF8E8E8E),
                placeholderColor = Color(0xFF8E8E8E)
            ),
            maxLines = 15,
            shape = RoundedCornerShape(8.dp)
        )
        Spacer(modifier = Modifier.height(16.dp))
       InterestButtons()
    }
}


@Composable
fun ProfileRow(
    imgid: Int,
    nickname: String,
    gender: String,
    age: String,
    location: String
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.basic_background))
            .height(150.dp)

    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .background(colorResource(id = R.color.grey_background), CircleShape)
                .padding(start = 40.dp, top = 34.dp)
        ) {
            Image(
                painter = painterResource(id = imgid),
                contentDescription = null,
                modifier = Modifier
                    .width(110.dp)
                    .height(110.dp),
                contentScale = ContentScale.Crop
            )
        }
        Spacer(modifier = Modifier.width(16.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),

            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = nickname,
                color = Color.White,
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 34.dp, bottom = 20.dp)
            )

            Text(
                text = "$age / $gender",
                color = Color.Gray,
                fontSize = 16.sp,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = location,
                color = Color.Gray,
                fontSize = 16.sp
            )
        }
    }
}

@Composable
fun InterestGrid(list: List<String>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()

    ) {
        Text(
            text = "관심 종목",
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 40.dp)
        )
        Spacer(modifier = Modifier.height(5.dp))
        Box(
            modifier = Modifier
                .padding(start = 20.dp, end = 20.dp)
                .background(
                    colorResource(id = R.color.grey_item_background),
                    shape = RoundedCornerShape(8.dp)
                )
                .fillMaxWidth()
                .height(100.dp)
        )
        {
            LazyVerticalGrid(
                columns = GridCells.Fixed(5),
                // content padding
                contentPadding = PaddingValues(
                    start = 10.dp,
                    top = 10.dp,
                    end = 10.dp,
                )
            ) {
                items(list.size) { size ->
                    InterestItem(list[size])
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
        }
    }
}


@Composable
fun InterestItem(interest: String) {
    Box(
        modifier = Modifier
            .padding(8.dp)
            .width(54.dp)
            .height(25.dp)
            .background(
                color = colorResource(id = R.color.mint),
                shape = RoundedCornerShape(8.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = interest,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,

            )
    }
}

@Composable
fun InterestButtons() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            ,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        InterestButton(text = "관심 친구 추가")
        InterestButton(text = "쪽지 보내기")
    }
}

@Composable
fun InterestButton(text: String) {
    Button(
        onClick = { /* Handle button click */ },
        colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.mint)),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .height(50.dp)
            .width(150.dp)
    ) {
        Text(
            text = text,
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
    }
}
@Preview
@Composable
private fun ScreenPreview() {
    FriendProfileScreen()
}