package com.app.cvbuilder.main_screens.cv_creation.cv_create_starting_screen.data

import androidx.room.Entity
import androidx.room.PrimaryKey

private const val TABLE_NAME = "user_cv_name"

@Entity(tableName = TABLE_NAME)
data class UserCVName(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String
)