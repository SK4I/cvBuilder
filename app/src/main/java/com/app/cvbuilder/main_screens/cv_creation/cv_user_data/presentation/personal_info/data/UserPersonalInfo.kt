package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.personal_info.data

import androidx.room.Entity

private const val TABLE_NAME = "user_personal_info"

@Entity(tableName = TABLE_NAME)
data class UserPersonalInfo(
    val name: String,
    val date: String,
    val email: String,
    val phoneNumber: String,
    val website: String,
    val address: String,
    val postalCode: String,
    val city: String,
    val region: String,
    val country: String
)