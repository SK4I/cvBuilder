package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.certificate.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.certificate.domain.UserCertificate

@Dao
interface UserCertificatesDao {
    @Insert
    suspend fun updateUserCertificates(userCertificates: List<UserCertificates>)

    @Query("SELECT * FROM user_certificates")
    suspend fun getUserCertificates(): List<UserCertificate>
}