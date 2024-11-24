package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.companies.data

import android.provider.ContactsContract.Data
import com.app.cvbuilder.CvApplication
import com.app.cvbuilder.core.db.AppDatabase
import com.app.cvbuilder.core.domain.DataError
import com.app.cvbuilder.core.domain.Result

class UserCompaniesRepositoryImpl : UserCompaniesRepository {
    override suspend fun updateUserCompanies(userCompanies: UserCompanies): Result<UserCompanies, DataError.Local> {
        val userCompaniesDao = CvApplication.database.userCompaniesDao()

        return try {
            userCompaniesDao.updateUserCompanies(userCompanies = userCompanies)
            Result.Success(userCompanies)
        } catch (e: Exception) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }
}