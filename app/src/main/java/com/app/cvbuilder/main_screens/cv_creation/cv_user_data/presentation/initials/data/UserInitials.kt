package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.initials.data

import androidx.room.Entity
import androidx.room.PrimaryKey

private const val TABLE_NAME = "user_initials"

@Entity(tableName = TABLE_NAME)
data class UserInitials(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val userName: String,
    val userSurname: String
)