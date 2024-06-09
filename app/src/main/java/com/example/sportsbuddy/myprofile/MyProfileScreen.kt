@file:OptIn(ExperimentalLayoutApi::class)

package com.example.sportsbuddy.myprofile

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.Divider
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sportsbuddy.R
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.TextButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.foundation.layout.FlowRow
import com.example.sportsbuddy.login.LoginActivity


@Preview
@Composable
fun MyProfileScreen() {

    var editableText by remember { mutableStateOf("에이치씨아이") }
    val interests = remember { mutableStateOf(listOf("농구", "야구", "볼링", "헬스", "필라테스", "풋살")) }
    val context = LocalContext.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.background_black)),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(55.dp)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Icon(imageVector = Icons.Default.Clear, contentDescription = "", tint = Color.White)
            Box(modifier = Modifier.weight(1f), contentAlignment = Alignment.Center) {
                Text(text = "프로필 설정", fontSize = 18.sp, color = Color.White)
            }
            Text(text = "저장", fontSize = 18.sp, color = Color.White, modifier = Modifier.clickable {
                Toast
                    .makeText(context, "로그아웃", Toast.LENGTH_SHORT)
                    .show()

            })

        }

        Divider(color = Color.White)
        Spacer(modifier = Modifier.height(29.dp))
        Image(
            painter = painterResource(id = R.drawable.img_profile),
            contentDescription = "",
            modifier = Modifier
                .size(160.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Column(
            modifier = Modifier
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text = "닉네임",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 13.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))

            EditableTextField(
                text = editableText,
                onTextChange = { editableText = it },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "동네설정",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 13.dp)
            )
            Spacer(modifier = Modifier.height(15.dp))

            DrawEditLocation()

            Spacer(modifier = Modifier.height(39.dp))
            Text(
                text = "관심종목",
                color = Color.White,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 13.dp)
            )
            Spacer(modifier = Modifier.height(6.dp))
            InterestsSection(
                interests = interests.value,
                onAddInterest = { newInterest ->
                    interests.value = interests.value + newInterest
                }
            )
            Spacer(modifier = Modifier.height(14.dp))
        }
        Button(
            onClick = {
                val intent = Intent(context, LoginActivity::class.java)
                context.startActivity(intent)
                Toast
                    .makeText(context, "로그아웃", Toast.LENGTH_SHORT)
                    .show()
            },
            modifier = Modifier.size(width = 150.dp, height = 50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF6D6D6D)
            ),
            shape = RoundedCornerShape(10.dp)
        ) {
            Text(text = "로그아웃", color = Color.White)
        }
    }
}

@Composable
fun EditableTextField(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var isEnabled by remember { mutableStateOf(false) }

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
                .padding(vertical = 4.dp)
                .padding(start = 5.dp),
            enabled = isEnabled,
            textStyle = TextStyle(fontSize = 24.sp, color = Color.White)
        )
        IconButton(
            onClick = { isEnabled = !isEnabled },
            modifier = Modifier.padding(start = 8.dp)
        ) {
            Icon(
                Icons.Default.Edit,
                tint = colorResource(id = R.color.icon_gray),
                contentDescription = "Edit"
            )
        }
    }
}


@Composable
fun LocationSpinner(
    cities: List<City>,
    selectedCity: City?,
    onCitySelected: (City) -> Unit,
    selectedDistrict: District?,
    onDistrictSelected: (District) -> Unit,
    selectedNeighborhood: Neighborhood?,
    onNeighborhoodSelected: (Neighborhood) -> Unit
) {
    var isCityDropdownExpanded by remember { mutableStateOf(false) }
    var isDistrictDropdownExpanded by remember { mutableStateOf(false) }
    var isNeighborhoodDropdownExpanded by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        // City selection dropdown menu
        Column(modifier = Modifier.weight(1f)) {
            Box(
                modifier = Modifier
                    .clickable { isCityDropdownExpanded = !isCityDropdownExpanded }
                    .padding(5.dp)
                    .border(1.dp, Color(0xFF45B5AA), RoundedCornerShape(10.dp))
                    .background(Color(0xFF45B5AA), RoundedCornerShape(8.dp))
                    .size(width = 95.dp, height = 30.dp)
            ) {
                Row(
                    modifier = Modifier.align(Alignment.Center),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = selectedCity?.name ?: "'시' 선택",
                        color = Color.White,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Expand City Dropdown",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            DropdownMenu(
                expanded = isCityDropdownExpanded,
                onDismissRequest = { isCityDropdownExpanded = false }
            ) {
                cities.forEach { city ->
                    DropdownMenuItem(
                        onClick = {
                            onCitySelected(city)
                            isCityDropdownExpanded = false
                        }
                    ) {
                        Text(city.name)
                    }
                }
            }
        }

        // District selection dropdown menu
        Column(modifier = Modifier.weight(1f)) {
            Box(
                modifier = Modifier
                    .clickable {
                        if (selectedCity == null) {
                            Toast
                                .makeText(context, "'시'를 먼저 선택하세요", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            isDistrictDropdownExpanded = !isDistrictDropdownExpanded
                        }
                    }
                    .padding(5.dp)
                    .border(1.dp, Color(0xFF45B5AA), RoundedCornerShape(10.dp))
                    .background(Color(0xFF45B5AA), RoundedCornerShape(8.dp))
                    .size(width = 95.dp, height = 30.dp)
            ) {
                Row(
                    modifier = Modifier.align(Alignment.Center),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = selectedDistrict?.name ?: "'구' 선택",
                        color = Color.White,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Expand District Dropdown",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            DropdownMenu(
                expanded = isDistrictDropdownExpanded,
                onDismissRequest = { isDistrictDropdownExpanded = false }
            ) {
                selectedCity?.districts?.forEach { district ->
                    DropdownMenuItem(
                        onClick = {
                            onDistrictSelected(district)
                            isDistrictDropdownExpanded = false
                        }
                    ) {
                        Text(district.name)
                    }
                }
            }
        }

        // Neighborhood selection dropdown menu
        Column(modifier = Modifier.weight(1f)) {
            Box(
                modifier = Modifier
                    .clickable {
                        if (selectedDistrict == null) {
                            Toast
                                .makeText(context, "'구'를 먼저 선택하세요", Toast.LENGTH_SHORT)
                                .show()
                        } else {
                            isNeighborhoodDropdownExpanded = !isNeighborhoodDropdownExpanded
                        }
                    }
                    .padding(5.dp)
                    .border(1.dp, Color(0xFF45B5AA), RoundedCornerShape(10.dp))
                    .background(Color(0xFF45B5AA), RoundedCornerShape(8.dp))
                    .size(width = 95.dp, height = 30.dp)
            ) {
                Row(
                    modifier = Modifier.align(Alignment.Center),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = selectedNeighborhood?.name ?: "'동' 선택",
                        color = Color.White,
                        modifier = Modifier.weight(1f),
                        textAlign = TextAlign.Center
                    )
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = "Expand Neighborhood Dropdown",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }

            DropdownMenu(
                expanded = isNeighborhoodDropdownExpanded,
                onDismissRequest = { isNeighborhoodDropdownExpanded = false }
            ) {
                selectedDistrict?.neighborhoods?.forEach { neighborhood ->
                    DropdownMenuItem(
                        onClick = {
                            onNeighborhoodSelected(neighborhood)
                            isNeighborhoodDropdownExpanded = false
                        }
                    ) {
                        Text(neighborhood.name)
                    }
                }
            }
        }
    }
}


@Composable
fun DrawEditLocation() {
    var selectedCity by remember { mutableStateOf<City?>(null) }
    var selectedDistrict by remember { mutableStateOf<District?>(null) }
    var selectedNeighborhood by remember { mutableStateOf<Neighborhood?>(null) }

    LocationSpinner(
        cities = cities,
        selectedCity = selectedCity,
        onCitySelected = { selectedCity = it },
        selectedDistrict = selectedDistrict,
        onDistrictSelected = { selectedDistrict = it },
        selectedNeighborhood = selectedNeighborhood,
        onNeighborhoodSelected = { selectedNeighborhood = it }
    )
}

@Composable
fun InterestChip(
    interest: String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(55.dp)
            .height(25.dp)
            .background(
                color = Color(0xFF45B5AA),
                shape = RoundedCornerShape(5.dp)
            ),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = interest,
            color = Color.White,
            fontSize = 12.sp
        )
    }
}

@Composable
fun InterestsSection(interests: List<String>, onAddInterest: (String) -> Unit) {
    val showDialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(140.dp)
            .background(
                colorResource(id = R.color.textfield_gray),
                shape = RoundedCornerShape(15.dp)
            )
            .padding(horizontal = 14.dp, vertical = 14.dp)
    ) {
        FlowRow(
            modifier = Modifier.fillMaxWidth(),

        ) {
            interests.forEach { interest ->
                InterestChip(interest = interest, modifier = Modifier.padding(4.dp))
            }
        }
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            text = "+ 추가하기",
            color = colorResource(id = R.color.icon_gray),
            fontSize = 14.sp,
            modifier = Modifier
                .clickable { showDialog.value = true }
                .padding(4.dp)
        )
    }

    if (showDialog.value) {
        AddInterestDialog(
            onDismiss = { showDialog.value = false },
            onConfirm = { newInterest ->
                onAddInterest(newInterest)
                showDialog.value = false
            }
        )
    }
}


@Composable
fun AddInterestDialog(
    onDismiss: () -> Unit,
    onConfirm: (String) -> Unit
) {
    val newInterest = remember { mutableStateOf("") }

    AlertDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            TextButton(onClick = {
                onConfirm(newInterest.value)
                onDismiss()
            }) {
                Text("추가")
            }
        },
        dismissButton = {
            TextButton(onClick = { onDismiss() }) {
                Text("취소")
            }
        },
        title = { Text("관심종목 추가") },
        text = {
            OutlinedTextField(
                value = newInterest.value,
                onValueChange = { newInterest.value = it },
                label = { Text("관심종목 입력") }
            )
        }
    )
}
