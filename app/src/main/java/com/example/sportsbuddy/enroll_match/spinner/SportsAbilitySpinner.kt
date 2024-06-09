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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
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


data class SportsAbility(val name: String)

val abilities = listOf(
    SportsAbility("초급자"),
    SportsAbility("중급자"),
    SportsAbility("상급자"),
    SportsAbility("초고수")
)

@Composable
fun AbilitiesSpinner(
    abilities: List<SportsAbility>,
    selectedAbility: SportsAbility?,
    onAbilitySelected: (SportsAbility) -> Unit
) {
    var isAbilityDropdownExpanded by remember { mutableStateOf(false) }
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
                        isAbilityDropdownExpanded = !isAbilityDropdownExpanded
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
                Text(
                    selectedAbility?.name ?: "'Ability' 선택",
                    modifier = Modifier.align(Alignment.Center), color = Color.White
                )
            }

            DropdownMenu(
                expanded = isAbilityDropdownExpanded,
                onDismissRequest = { isAbilityDropdownExpanded = false }
            ) {
                abilities.forEach { ability ->
                    DropdownMenuItem(onClick = {
                        onAbilitySelected(ability)
                        isAbilityDropdownExpanded = false
                    }) {
                        Text(ability.name)
                    }
                }
            }
        }
    }
}

@Composable
fun DrawEditSportsAbility() {
    var selectedAbility by remember { mutableStateOf<SportsAbility?>(null) }

    AbilitiesSpinner(
        abilities = abilities,
        selectedAbility = selectedAbility,
        onAbilitySelected = { selectedAbility = it }
    )
}
