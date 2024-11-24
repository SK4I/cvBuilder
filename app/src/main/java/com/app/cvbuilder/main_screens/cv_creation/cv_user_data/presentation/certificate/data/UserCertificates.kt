package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.certificate.data

import androidx.room.Entity
import androidx.room.PrimaryKey

private const val TABLE_NAME = "user_certificates"

@Entity(tableName = TABLE_NAME)
data class UserCertificates(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val title: String = "",
    val date: String = "",
    val description: String = "",
)