package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import com.app.cvbuilder.core.di.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.compose.KoinApplication

@Composable
fun KoinPreview(content: @Composable () -> Unit) {
    val context = LocalContext.current
    KoinApplication(application = {
        androidContext(context)
        modules(appModule)
    }) {
        content()
    }
}