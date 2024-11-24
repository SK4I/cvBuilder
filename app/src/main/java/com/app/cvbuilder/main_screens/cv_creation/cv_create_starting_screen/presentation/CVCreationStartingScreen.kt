package com.app.cvbuilder.main_screens.cv_creation.cv_create_starting_screen.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.cvbuilder.core.ui.theme.BackgroundColorLight
import com.app.cvbuilder.core.ui.theme.PrimaryColorLight
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.CVCreationScaffold
import org.koin.androidx.compose.koinViewModel

@Preview
@Composable
fun CVCreationStartingScreenPreview() {
    CVCreationStartingScreen({}) { }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CVCreationStartingScreen(onNextButtonClick: () -> Unit, onPreviousButtonClick: () -> Unit) {
    CVCreationScaffold(
        sectionTitle = "CV Name",
        content = { CVCreationStartContent() },
        onNextButtonClick = onNextButtonClick,
        onPreviousButtonClick = onPreviousButtonClick,
        isNextStepAllowed = true
    )
}

@Composable
private fun CVCreationStartContent() {
    Surface(
        modifier = Modifier.padding(horizontal = 16.dp),
        color = BackgroundColorLight
    ) {
        CvNameTextInput()
    }
}

@Composable
private fun CvNameTextInput() {

    val cvName = remember { mutableStateOf("") }
    val viewModel: UserCVNameViewModel = koinViewModel()
    val transactionState = remember { viewModel.userDataUpdateState }

    Box(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 64.dp)
                .height(56.dp)
                .background(color = PrimaryColorLight, shape = RoundedCornerShape(16.dp))
        ) {
            TextField(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                value = cvName.value,
                onValueChange = {
                    cvName.value = it
                    viewModel.onCVNameChanged(cvName.value)
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
                        text = "Enter CV Name"
                    )
                },
                placeholder = { Text("Input") },
            )
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .graphicsLayer { alpha = if (transactionState.value) 1.0f else 1.0f }
                .padding(bottom = 80.dp)
                .align(Alignment.BottomCenter),
            color = Color.Black,
            text = "saved"
        )
    }
}