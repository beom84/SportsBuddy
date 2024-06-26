package com.example.sportsbuddy.enroll_match

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
//noinspection UsingMaterialAndMaterial3Libraries
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sportsbuddy.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
    onBackIconClick: () -> Unit,
    title: String,
    titleColor: Color,
    onRightIconClick: (() -> Unit)?,
    rightIconImgId: Int?,
) {
    androidx.compose.material.TopAppBar(
        backgroundColor = colorResource(id = R.color.basic_background),
        contentPadding = PaddingValues(horizontal = 5.dp),
        elevation = 0.dp
    ) {
        Row(
            modifier = Modifier.fillMaxWidth().height(56.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            // 뒤로 가기(좌측 아이콘)
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(start = 16.dp)
            ) {
                Icon(imageVector = Icons.Default.Clear, contentDescription = "", tint = Color.White)

            }
            // title
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Text(
                    text = title,
                    fontFamily = FontFamily(Font(R.font.pretendard_semibold)),
                    fontSize = 18.sp,
                    color = titleColor,
                    modifier = Modifier
                        .align(Alignment.Center)
                )
            }
            // 우측 아이콘
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                if (rightIconImgId != null && onRightIconClick != null) {
                    IconButton(
                        onClick = onRightIconClick,
                        modifier = Modifier.align(Alignment.CenterEnd),
                    ) {
                        Image(
                            painter = painterResource(id = rightIconImgId),
                            modifier = Modifier.size(40.dp),
                            contentDescription = "우측 아이콘"
                        )
                    }
                }
            }
        }
    }
}