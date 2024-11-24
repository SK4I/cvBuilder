package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.companies.data

import com.app.cvbuilder.core.domain.DataError
import com.app.cvbuilder.core.domain.Result

interface UserCompaniesRepository {
    suspend fun updateUserCompanies(userCompanies: UserCompanies): Result<UserCompanies, DataError.Local>
}