package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.initials.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.app.cvbuilder.core.domain.Result
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.UserDataBaseViewModel
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.initials.data.UserInitials
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.initials.data.UserInitialsRepository

class UserInitialsViewModel(private val userInitialsRepository: UserInitialsRepository) :
    UserDataBaseViewModel() {

    var userName by mutableStateOf("")
    var userSurname by mutableStateOf("")

    suspend fun onUserDataChanged(userName: String, userSurname: String) {
        this.userName = userName
        this.userSurname = userSurname

        updateUserData(userName, userSurname)
    }

    private suspend fun updateUserData(userName: String, userSurname: String) {
        val userInitials = UserInitials(userName = userName, userSurname = userSurname)
        when (userInitialsRepository.updateUserInitials(userInitials)) {
            is Result.Error -> {
                onDataInsertedError()
            }

            is Result.Success -> {
                onDataInsertedSuccess()
            }
        }
    }
}