package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.language.data

import androidx.room.Entity
import androidx.room.PrimaryKey

private const val TABLE_NAME = "user_cv_language"

@Entity(tableName = TABLE_NAME)
data class CVLanguageItem(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val language: String
)