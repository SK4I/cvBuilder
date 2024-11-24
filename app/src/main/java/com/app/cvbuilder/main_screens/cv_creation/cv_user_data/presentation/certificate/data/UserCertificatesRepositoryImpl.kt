package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.certificate.data

import com.app.cvbuilder.CvApplication
import com.app.cvbuilder.core.domain.DataError
import com.app.cvbuilder.core.domain.Result

class UserCertificatesRepositoryImpl : UserCertificatesRepository {
    override suspend fun updateUserCertificates(userCertificates: List<UserCertificates>): Result<List<UserCertificates>, DataError.Local> {
        val userCertificatesDao = CvApplication.database.userCertificatesDao()

        return try {
            userCertificatesDao.updateUserCertificates(userCertificates = userCertificates)
            Result.Success(userCertificates)
        } catch (e: Exception) {
            Result.Error(DataError.Local.DISK_FULL)
        }
    }
}