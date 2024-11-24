package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.companies.presentation

import com.app.cvbuilder.core.domain.Result
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.UserDataBaseViewModel
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.companies.data.UserCompanies
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.companies.data.UserCompaniesRepositoryImpl

class UserCompaniesViewModel(private val userCompaniesRepository: UserCompaniesRepositoryImpl) :
    UserDataBaseViewModel() {

    val companyList = mutableListOf(CompanyItem.empty())

    suspend fun onNextButtonClicked(userCompanies: UserCompanies) {
        updateUserCompanies(userCompanies)
    }

    private suspend fun updateUserCompanies(userCompanies: UserCompanies) {
        when (userCompaniesRepository.updateUserCompanies(userCompanies)) {
            is Result.Success -> {
                onDataInsertedSuccess()
            }

            is Result.Error -> {
                onDataInsertedError()
            }
        }
    }
}