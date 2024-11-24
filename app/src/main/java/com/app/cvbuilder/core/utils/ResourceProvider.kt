package com.app.cvbuilder.core.utils

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.StringRes

interface ResourceProvider {
    fun getString(@StringRes id: Int): String

    @ColorInt
    fun getColor(@ColorRes id: Int): Int
}

class AndroidResourceProvider(private val context: Context) : ResourceProvider {
    override fun getString(id: Int): String {
        return context.getString(id)
    }

    override fun getColor(id: Int): Int {
        return context.getColor(id)
    }
}