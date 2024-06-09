package com.example.sportsbuddy.enroll_match.spinner

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.sportsbuddy.R

@Composable
fun LocationSpinner(
    districts: List<District>,
    selectedDistrict: District?,
    onDistrictSelected: (District) -> Unit,
    selectedNeighborhood: Neighborhood?,
    onNeighborhoodSelected: (Neighborhood) -> Unit
) {
    var isDistrictDropdownExpanded by remember { mutableStateOf(false) }
    var isNeighborhoodDropdownExpanded by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 35.dp)
            .padding(end = 37.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        // 시 선택 드롭다운 메뉴

        // 구 선택 드롭다운 메뉴
        Row(
            modifier = Modifier.weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .clickable {
                        isDistrictDropdownExpanded = !isDistrictDropdownExpanded
                    }
                    .padding(5.dp)

                    .background(
                        color = colorResource(id = R.color.mint),
                        shape = RoundedCornerShape(8.dp)
                    )
                    .width(85.dp)
                    .height(25.dp)
            ) {
                Row(
                    modifier = Modifier.align(Alignment.Center),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        selectedDistrict?.name ?: "'구' 선택",
                         color = Color.White
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
                expanded = isDistrictDropdownExpanded,
                onDismissRequest = { isDistrictDropdownExpanded = false }
            ) {
                districts.forEach { district ->
                    DropdownMenuItem({
                        Text(district.name)
                    }, onClick = {
                        onDistrictSelected(district)
                        isDistrictDropdownExpanded = false
                    })
                }
            }

            // 동 선택 드롭다운 메뉴
            Column(
                modifier = Modifier.weight(1f)
            ) {
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

                        .background(
                            color = colorResource(id = R.color.mint),
                            shape = RoundedCornerShape(8.dp)
                        )
                        .width(85.dp)
                        .height(25.dp)
                ) {
                    Row(
                        modifier = Modifier.align(Alignment.Center),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            selectedNeighborhood?.name ?: "'동' 선택",
                             color = Color.White
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
                    expanded = isNeighborhoodDropdownExpanded,
                    onDismissRequest = { isNeighborhoodDropdownExpanded = false }
                ) {
                    selectedDistrict?.neighborhoods?.forEach { neighborhood ->
                        DropdownMenuItem({
                            Text(neighborhood.name)
                        }, onClick = {
                            onNeighborhoodSelected(neighborhood)
                            isNeighborhoodDropdownExpanded = false
                        })
                    }
                }


            }
        }
    }
}

@Composable
fun DrawEditLocation() {
    var selectedDistrict by remember { mutableStateOf<District?>(null) }
    var selectedNeighborhood by remember { mutableStateOf<Neighborhood?>(null) }

    LocationSpinner(
        districts = districts,
        selectedDistrict = selectedDistrict,
        onDistrictSelected = { selectedDistrict = it },
        selectedNeighborhood = selectedNeighborhood,
        onNeighborhoodSelected = { selectedNeighborhood = it }
    )
}

@Preview
@Composable
private fun hi() {
    DrawEditLocation()
}