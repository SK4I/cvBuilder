package com.app.cvbuilder.main_screens.cv_creation.cv_create_starting_screen.data

import com.app.cvbuilder.core.domain.DataError
import com.app.cvbuilder.core.domain.Result
import kotlinx.coroutines.flow.Flow

interface UserCVNameRepository {

    suspend fun updateUserCVName(userCVName: UserCVName): Result<UserCVName, DataError.Local>

    suspend fun getUserCVName(): Flow<Result<List<UserCVName>, DataError.Local>>
}