package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.cvbuilder.core.ui.theme.BackgroundColorLight

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CVCreationScaffold(
    sectionTitle: String,
    content: @Composable () -> Unit,
    onNextButtonClick: () -> Unit,
    onPreviousButtonClick: () -> Unit,
    isNextStepAllowed: Boolean = false,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        containerColor = BackgroundColorLight,
        content = { content() },
        topBar = { CvCreationTopBar(sectionTitle) },
        bottomBar = {
            BottomNavigationArrows(
                onLeftButtonClick = onPreviousButtonClick,
                onRightButtonClick = onNextButtonClick,
                isNextStepAllowed = isNextStepAllowed
            )
        }
    )
}