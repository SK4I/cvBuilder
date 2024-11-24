package com.app.cvbuilder.core.db

import androidx.room.Entity
import androidx.room.PrimaryKey

private const val TABLE_NAME = "user"

@Entity(tableName = TABLE_NAME)
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val name: String,
    val surname: String
)