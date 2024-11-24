package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.initials.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.cvbuilder.core.ui.theme.BackgroundColorLight
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.CVCreationScaffold
import kotlinx.coroutines.launch
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun UserInitialsScreenPreview() {
    UserInitialsScreen({}) {}
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun UserInitialsScreen(onNextButtonClicked: () -> Unit, onPreviousButtonClick: () -> Unit) {
    CVCreationScaffold(
        sectionTitle = "Initials",
        content = { UserData() },
        onNextButtonClick = onNextButtonClicked,
        onPreviousButtonClick = onPreviousButtonClick
    )
}

@Composable
fun UserData() {

    val viewModel: UserInitialsViewModel = koinViewModel()

    val userName = rememberSaveable { mutableStateOf(viewModel.userName) }
    val userSurname = rememberSaveable { mutableStateOf(viewModel.userSurname) }
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(BackgroundColorLight)
    ) {
        OutlinedTextField(
            value = userName.value,
            onValueChange = {
                userName.value = it
                coroutineScope.launch {
                    viewModel.onUserDataChanged(userName.value, userSurname.value)
                }
            },
            label = { Text("Name") },
            placeholder = { Text("Enter your username") },
            colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colorScheme.surface),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = userSurname.value,
            onValueChange = {
                userSurname.value = it
                coroutineScope.launch {
                    viewModel.onUserDataChanged(userName.value, userSurname.value)
                }
            },
            label = { Text("Surname") },
            placeholder = { Text("Enter your username") },
            colors = TextFieldDefaults.textFieldColors(backgroundColor = MaterialTheme.colorScheme.surface),
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun ButtonNext(modifier: Modifier = Modifier, onNextButtonClicked: () -> Unit) {
    IconButton(onClick = {
        onNextButtonClicked.invoke()
    }) {
        Icon(
            modifier = modifier,
            imageVector = Icons.Default.ArrowForward,
            contentDescription = "ButtonNext"
        )
    }
}