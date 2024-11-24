package com.app.cvbuilder.main_screens.cv_creation.cv_templates_screen.domain

import android.net.Uri

data class TemplateItem(
    val isAvailable: Boolean = true,
    val imageUrl: Uri,
    val title: String
)