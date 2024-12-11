package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.language.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy

@Dao
interface CVLanguageDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateLanguage(language: CVLanguageItem)
}