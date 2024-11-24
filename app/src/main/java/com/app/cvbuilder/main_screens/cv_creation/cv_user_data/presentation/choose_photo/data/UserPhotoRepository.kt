package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.choose_photo.data

import com.app.cvbuilder.core.domain.DataError
import com.app.cvbuilder.core.domain.Result

interface UserPhotoRepository {
    suspend fun updateUserPhoto(userPhoto: UserPhoto): Result<UserPhoto, DataError.Local>
}