package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.certificate.data

import com.app.cvbuilder.core.domain.DataError
import com.app.cvbuilder.core.domain.Result

interface UserCertificatesRepository {
    suspend fun updateUserCertificates(userCertificates: List<UserCertificates>): Result<List<UserCertificates>, DataError.Local>
}