package com.app.cvbuilder.main_screens.cv_creation.cv_create_starting_screen.data

import com.app.cvbuilder.CvApplication
import com.app.cvbuilder.core.domain.DataError
import com.app.cvbuilder.core.domain.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class UserCVNameRepositoryImpl : UserCVNameRepository {
    override suspend fun updateUserCVName(userCVName: UserCVName): Result<UserCVName, DataError.Local> {
        val userCVNameDao = CvApplication.database.userCVNameDao()

        return try {
            userCVNameDao.updateUserCVName(userCVName = userCVName)
            Result.Success(userCVName)
        } catch (e: Exception) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }

    override suspend fun getUserCVName(): Flow<Result<List<UserCVName>, DataError.Local>> = flow {

        val userCVNameDao = CvApplication.database.userCVNameDao()

        try {
            val userCVName = userCVNameDao.getCVName()

            emit(Result.Success(userCVName))
        } catch (e: Exception) {
            emit(Result.Error(DataError.Local.DISK_FULL))
        }
    }
}