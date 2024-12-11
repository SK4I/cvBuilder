package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.settings.domain

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class CVSettingTypeConverter(private val gson: Gson) {

    @TypeConverter
    fun fromCVSettingType(value: CVSettingType): String {
        return gson.toJson(value)
    }

    @TypeConverter
    fun toCVSettingType(value: String): CVSettingType {
        val type = object : TypeToken<CVSettingType>() {}.type
        return gson.fromJson(value, type)
    }
}