package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.language.data

import com.app.cvbuilder.core.domain.DataError
import com.app.cvbuilder.core.domain.Result

interface CVLanguageRepository {
    suspend fun updateUserCvLanguage(language: CVLanguageItem): Result<CVLanguageItem, DataError.Local>
}