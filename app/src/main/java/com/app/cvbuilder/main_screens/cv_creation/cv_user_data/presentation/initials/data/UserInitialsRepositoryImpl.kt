package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.initials.data

import com.app.cvbuilder.CvApplication
import com.app.cvbuilder.core.domain.DataError
import com.app.cvbuilder.core.domain.Result

class UserInitialsRepositoryImpl : UserInitialsRepository {

    override suspend fun updateUserInitials(userInitials: UserInitials): Result<UserInitials, DataError.Local> {
        val userInitialsDao = CvApplication.database.userInitialsDao()

        return try {
            val userInitialsData = UserInitials(userName = "John", userSurname = "Dou")
            userInitialsDao.insertUserInitials(userInitials)
            Result.Success(userInitialsData)
        } catch (e: Exception) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }
}