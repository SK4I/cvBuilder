package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.certificate.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.app.cvbuilder.core.domain.Result
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.UserDataBaseViewModel
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.certificate.data.UserCertificates
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.certificate.data.UserCertificatesRepository
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.certificate.domain.UserCertificate

class UserCertificateViewModel(private val userCertificatesRepository: UserCertificatesRepository) :
    UserDataBaseViewModel() {

    //temoprary list
    val certificatesList = arrayListOf(
        UserCertificate.empty(),
        UserCertificate.empty()
    )

    suspend fun onNextButtonClick(userCertificates: List<UserCertificates>) {
        updateUserCertificates(userCertificates)
    }

    private suspend fun updateUserCertificates(userCertificates: List<UserCertificates>) {

        when (userCertificatesRepository.updateUserCertificates(userCertificates)) {
            is Result.Error -> {
                onDataInsertedError()
            }

            is Result.Success -> {
                onDataInsertedSuccess()
            }
        }
    }
}