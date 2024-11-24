package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.language.data

import com.app.cvbuilder.CvApplication
import com.app.cvbuilder.core.domain.DataError
import com.app.cvbuilder.core.domain.Result

class CVLanguageRepositoryImpl : CVLanguageRepository {
    override suspend fun updateUserCvLanguage(language: CVLanguageItem): Result<CVLanguageItem, DataError.Local> {
        val userCVLanguageDao = CvApplication.database.userCVLanguageDao()

        return try {
            userCVLanguageDao.updateLanguage(language = language)
            Result.Success(language)
        } catch (e: Exception) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }
}