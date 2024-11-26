package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.settings.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.cvbuilder.core.ui.theme.PrimaryColorLight
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.CVCreationScaffold
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.KoinPreview
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.toUserDataFlowSettings

@Preview
@Composable
fun CVSettingsScreenPreview() {
    KoinPreview {
        CVSettingsScreen({}, {})
    }
}

@Composable
fun CVSettingsScreen(onNextButtonClicked: () -> Unit, onPreviousButtonClick: () -> Unit) {
    CVCreationScaffold(
        sectionTitle = "CV Settings",
        content = { CVSettings() },
        onNextButtonClick = onNextButtonClicked,
        onPreviousButtonClick = onPreviousButtonClick
    )
}

@Composable
private fun CVSettings() {
    val options = listOf("Option 1", "Option 2", "Option 3")

    Column(modifier = Modifier.toUserDataFlowSettings()) {
        DropdownSetting(options,
            label = "Appearance of skills",
            onItemClicked = { chosenAppearance ->

            }
        )
        DropdownSetting(options,
            label = "CV text size",
            onItemClicked = { chosenTextSize ->

            }
        )
        DropdownSetting(options,
            label = "Order",
            onItemClicked = { chosenOrder ->

            }
        )
        DropdownSetting(options,
            label = "Date format",
            onItemClicked = { chosenDateFormat ->

            }
        )
        CVSettingsSwitch(
            label = "Show personal photo",
            initialValue = false,
            onValueChanged = { chosenValue ->

            }
        )
        CVSettingsSwitch(
            label = "Show birth date",
            initialValue = false,
            onValueChanged = { chosenValue ->

            }
        )
        CVSettingsSwitch(
            label = "Show duration calculation",
            initialValue = false,
            onValueChanged = { chosenValue ->

            }
        )
    }
}

@Composable
private fun CVSettingsSwitch(
    label: String,
    initialValue: Boolean,
    onValueChanged: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(top = 8.dp, start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(modifier = Modifier.weight(1f), text = label)
        Switch(checked = initialValue, onCheckedChange = { switchValue ->
            onValueChanged(switchValue)
        })
    }
}

@Composable
private fun DropdownSetting(
    options: List<String> = listOf("Option 1", "Option 2", "Option 3"),
    label: String,
    onItemClicked: (String) -> Unit
) {
    val item = remember { mutableStateOf("") }
    val itemExpanded = remember { mutableStateOf(false) }
    val selectedItem = remember { mutableStateOf("Select an option") }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(top = 8.dp)
            .background(color = PrimaryColorLight, shape = RoundedCornerShape(16.dp))
    ) {
        TextField(
            readOnly = true,
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .clickable { itemExpanded.value = !itemExpanded.value },
            value = item.value,
            trailingIcon = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = "Dropdown"
                )
            },
            onValueChange = {
                item.value = it

            },
            colors = TextFieldDefaults.colors(
                unfocusedIndicatorColor = Color.Transparent,
                unfocusedContainerColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent,
                focusedContainerColor = Color.Transparent,
            ),
            label = {
                Text(
                    style = TextStyle(fontSize = 12.sp),
                    text = label
                )
            },
            placeholder = { Text("Input") },
        )
        DropdownMenu(
            expanded = itemExpanded.value,
            onDismissRequest = { itemExpanded.value = false }
        ) {
            options.forEach { option ->
                DropdownMenuItem(
                    onClick = {
                        selectedItem.value = option
                        itemExpanded.value = false
                    },
                    text = { Text(option) }
                )
            }
        }
    }
}