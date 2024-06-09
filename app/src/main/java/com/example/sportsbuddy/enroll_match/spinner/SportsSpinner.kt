package com.example.sportsbuddy.enroll_match.spinner

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
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
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
import androidx.compose.ui.unit.dp
import com.example.sportsbuddy.R

@Composable
fun SportsSpinner(
    sports: List<Sport>,
    selectedSport: Sport?,
    onSportSelected: (Sport) -> Unit
) {
    var isSportDropdownExpanded by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 37.dp, end = 37.dp),
        horizontalArrangement = Arrangement.Center
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Box(
                modifier = Modifier
                    .clickable {
                        isSportDropdownExpanded = !isSportDropdownExpanded
                    }
                    .padding(5.dp)
                    .border(
                        width = 1.dp,
                        color = Color.LightGray,
                        shape = RoundedCornerShape(10.dp)
                    )
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
                        selectedSport?.name ?: "스포츠선택",
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
                expanded = isSportDropdownExpanded,
                onDismissRequest = { isSportDropdownExpanded = false }
            ) {
                sports.forEach { sport ->
                    DropdownMenuItem(onClick = {
                        onSportSelected(sport)
                        isSportDropdownExpanded = false
                    }) {
                        Text(sport.name)
                    }
                }
            }
        }
    }
}

@Composable
fun DrawEditSports() {
    var selectedSport by remember { mutableStateOf<Sport?>(null) }

    SportsSpinner(
        sports = sports,
        selectedSport = selectedSport,
        onSportSelected = { selectedSport = it }
    )
}
