package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.language.data

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface CVLanguageDao {
    @Insert
    suspend fun updateLanguage(language: CVLanguageItem)
}