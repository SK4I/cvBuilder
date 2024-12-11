package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.settings.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.settings.domain.CVSettingType
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.settings.domain.CVSettingItem
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
    val settingsList: List<CVSettingItem> = listOf(
        CVSettingItem(
            label = "Appearance of skills",
            type = CVSettingType.Dropdown(value = "", options = listOf("1", "2", "3"))
        ),
        CVSettingItem(
            label = "CV text size",
            type = CVSettingType.Dropdown(value = "", options = listOf("1", "2", "3"))
        ),
        CVSettingItem(
            label = "Chronological order",
            type = CVSettingType.Dropdown(value = "", options = listOf("1", "2", "3"))
        ),
        CVSettingItem(
            label = "Date format",
            type = CVSettingType.Dropdown(value = "", options = listOf("1", "2", "3"))
        ),
        CVSettingItem(
            label = "Show personal photo",
            type = CVSettingType.Switch(value = false)
        ),
        CVSettingItem(
            label = "Show date of birth",
            type = CVSettingType.Switch(value = false)
        ),
        CVSettingItem(
            label = "Show duration calculator",
            type = CVSettingType.Switch(value = false)
        )
    )
    Settings(settingsList)
}

@Composable
private fun Settings(settingsList: List<CVSettingItem>) {

    LazyColumn(modifier = Modifier.toUserDataFlowSettings()) {
        items(settingsList) { item ->
            when (item.type) {
                is CVSettingType.Switch -> CVSettingsSwitch(
                    label = item.label,
                    initialValue = false,
                    onValueChanged = {

                    })

                is CVSettingType.Dropdown -> DropdownSetting(
                    options = item.type.options,
                    label = item.label,
                    onItemClicked = {

                    })
            }
        }
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