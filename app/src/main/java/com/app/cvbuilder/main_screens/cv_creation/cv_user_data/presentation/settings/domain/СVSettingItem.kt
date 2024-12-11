package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.settings.domain

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_data_cv_setting_items")
data class CVSettingItem(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val label: String,
    val type: CVSettingType
)

sealed class CVSettingType {
    data class Dropdown(val value: String, val options: List<String>) : CVSettingType()
    data class Switch(val value: Boolean) : CVSettingType()
}