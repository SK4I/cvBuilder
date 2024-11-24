package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.choose_photo.data

import androidx.room.Entity
import androidx.room.PrimaryKey

private const val TABLE_NAME = "user_photo"

@Entity(tableName = TABLE_NAME)
data class UserPhoto(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val uri: String
)