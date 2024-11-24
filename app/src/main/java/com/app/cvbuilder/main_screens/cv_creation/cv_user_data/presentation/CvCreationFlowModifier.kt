package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.unit.dp
import com.app.cvbuilder.core.ui.theme.BackgroundColorLight

fun Modifier.toUserDataFlowSettings() = composed {
    fillMaxSize()
        .padding(bottom = 80.dp, start = 16.dp, end = 16.dp, top = 64.dp)
        .background(BackgroundColorLight)
}