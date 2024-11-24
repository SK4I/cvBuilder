package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.certificate.domain

import java.io.File

data class UserCertificate(
    val title: String = "",
    val date: String = "",
    val description: String = ""
) {
    companion object {
        fun empty(): UserCertificate {
            return UserCertificate()
        }
    }
}