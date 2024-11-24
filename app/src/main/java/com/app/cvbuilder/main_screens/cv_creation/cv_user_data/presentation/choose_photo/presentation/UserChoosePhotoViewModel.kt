package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.choose_photo.presentation

import com.app.cvbuilder.core.domain.Result
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.UserDataBaseViewModel
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.choose_photo.data.UserPhoto
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.choose_photo.data.UserPhotoRepository

class UserChoosePhotoViewModel(private val userPhotoRepository: UserPhotoRepository) :
    UserDataBaseViewModel() {

    suspend fun onUserPhotoUpdated(userPhoto: UserPhoto) {
        updatePhoto(userPhoto)
    }

    private suspend fun updatePhoto(userPhoto: UserPhoto) {
        when (userPhotoRepository.updateUserPhoto(userPhoto)) {
            is Result.Error -> {
                onDataInsertedError()
            }

            is Result.Success -> {
                onDataInsertedSuccess()
            }
        }
    }
}