package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.choose_photo.data

import com.app.cvbuilder.CvApplication
import com.app.cvbuilder.core.domain.DataError
import com.app.cvbuilder.core.domain.Result

class UserPhotoRepositoryImpl : UserPhotoRepository {

    override suspend fun updateUserPhoto(userPhoto: UserPhoto): Result<UserPhoto, DataError.Local> {
        val userPhotoDao = CvApplication.database.userPhotoDao()

        return try {
            userPhotoDao.updateUserPhoto(userPhoto)
            Result.Success(UserPhoto(uri = userPhoto.uri))
        } catch (e: Exception) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }
}