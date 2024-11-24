package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.language.presentation

import androidx.lifecycle.viewModelScope
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.UserDataBaseViewModel
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.language.data.CVLanguageItem
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.language.data.CVLanguageRepository
import kotlinx.coroutines.launch

class CVLanguageViewModel(private val cvLanguageRepository: CVLanguageRepository) :
    UserDataBaseViewModel() {

    fun onLanguageUpdated(language: CVLanguageItem) {
        viewModelScope.launch {
            updateUserLanguage(language = language)
        }
    }

    private suspend fun updateUserLanguage(language: CVLanguageItem) {
        cvLanguageRepository.updateUserCvLanguage(language = language)
    }
}