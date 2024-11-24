package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.companies.data

import androidx.room.Entity
import androidx.room.PrimaryKey

private const val TABLE_NAME = "user_companies"

@Entity(tableName = TABLE_NAME)
data class UserCompanies(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val companyName: String,
    val dateStarted: String,
    val dateEnded: String,
    val position: String
)