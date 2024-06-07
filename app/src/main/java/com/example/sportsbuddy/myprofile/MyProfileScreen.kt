package com.example.sportsbuddy.myprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sportsbuddy.R

@Preview
@Composable
fun MyProfileScreen() {

    var editableText by remember { mutableStateOf("부타련") }

    Column (modifier = Modifier
        .fillMaxSize()
        .background(Color.Black), horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(modifier = Modifier.height(85.dp))
        Image(
            painter = painterResource(id = R.drawable.img_profile_my1),
            contentDescription = "",
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape)
                .rotate(90f)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Column (modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp)){
            Text(text = "닉네임", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp, modifier = Modifier.padding(start = 13.dp))
            Spacer(modifier = Modifier.height(6.dp))

            EditableTextField(
                text = editableText,
                onTextChange = { editableText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            )
        }
        Row {

        }
        Row {

        }

    }
}

@Composable
fun EditableTextField(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = false
) {
    Row(
        modifier = modifier
            .background(
                colorResource(id = R.color.textfield_gray),
                shape = RoundedCornerShape(15.dp)
            )
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        BasicTextField(
            value = text,
            onValueChange = { onTextChange(it) },
            modifier = Modifier
                .weight(1f)
                .clip(RoundedCornerShape(15.dp))
                .background(Color.Transparent)
                .padding(vertical = 4.dp).padding(start = 5.dp),
            enabled = enabled,
            textStyle = TextStyle(fontSize = 24.sp, color = Color.White)
        )
        IconButton(
            onClick = { /* Add logic to enable editing */ },
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Icon(Icons.Default.Edit, tint = colorResource(id = R.color.icon_gray), contentDescription = "Edit")
        }
    }
}

