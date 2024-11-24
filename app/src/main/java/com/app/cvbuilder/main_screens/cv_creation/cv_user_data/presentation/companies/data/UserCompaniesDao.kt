package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.companies.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.app.cvbuilder.core.domain.Result

@Dao
interface UserCompaniesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUserCompanies(userCompanies: UserCompanies)

    @Query("SELECT * FROM user_companies")
    suspend fun getUserCompanies(): List<UserCompanies>
}