package com.app.cvbuilder.main_screens.cv_creation.cv_create_starting_screen.presentation

import androidx.lifecycle.viewModelScope
import com.app.cvbuilder.core.domain.Result
import com.app.cvbuilder.main_screens.cv_creation.cv_create_starting_screen.data.UserCVName
import com.app.cvbuilder.main_screens.cv_creation.cv_create_starting_screen.data.UserCVNameRepository
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.UserDataBaseViewModel
import kotlinx.coroutines.launch

class UserCVNameViewModel(private val cvNameRepository: UserCVNameRepository) :
    UserDataBaseViewModel() {

    fun onCVNameChanged(name: String) {
        updateCVName(name)
    }

    private fun updateCVName(name: String) {
        viewModelScope.launch {
            when (cvNameRepository.updateUserCVName(UserCVName(name = name))) {
                is Result.Error -> {
                    onDataInsertedError()
                }

                is Result.Success -> {
                    onDataInsertedSuccess()
                }
            }
        }
    }
}