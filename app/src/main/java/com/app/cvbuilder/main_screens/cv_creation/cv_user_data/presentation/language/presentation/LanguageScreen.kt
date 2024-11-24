package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.language.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.cvbuilder.core.ui.theme.PrimaryColorLight
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.CVCreationScaffold
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.KoinPreview
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.language.data.CVLanguageItem
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.toUserDataFlowSettings
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun LanguageScreenPreview() {
    KoinPreview {
        LanguageScreen({}, {})
    }
}

@Composable
fun LanguageScreen(onNextButtonClicked: () -> Unit, onPreviousButtonClick: () -> Unit) {
    CVCreationScaffold(
        sectionTitle = "CV Language",
        content = { Language() },
        onPreviousButtonClick = onPreviousButtonClick,
        onNextButtonClick = onNextButtonClicked
    )
}

@Composable
private fun Language() {

    val language = remember { mutableStateOf("") }
    val expanded = remember { mutableStateOf(false) }
    val selectedOption = remember { mutableStateOf("Select an option") }
    val options = listOf("Option 1", "Option 2", "Option 3")

    val viewModel: CVLanguageViewModel = koinViewModel()

    Column(
        modifier = Modifier.toUserDataFlowSettings()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .background(color = PrimaryColorLight, shape = RoundedCornerShape(16.dp))
        ) {
            TextField(
                readOnly = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp)
                    .clickable { expanded.value = !expanded.value },
                value = language.value,
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.ArrowDropDown,
                        contentDescription = "Dropdown"
                    )
                },
                onValueChange = {
                    language.value = it

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
                        text = "Language"
                    )
                },
                placeholder = { Text("Input") },
            )
            DropdownMenu(
                expanded = expanded.value,
                onDismissRequest = { expanded.value = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        onClick = {
                            selectedOption.value = option
                            expanded.value = false
                            viewModel.onLanguageUpdated(CVLanguageItem(language = selectedOption.value))
                        },
                        text = { Text(option) }
                    )
                }
            }
        }
    }
}