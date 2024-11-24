package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

abstract class UserDataBaseViewModel : ViewModel() {
    private val _userDataUpdateState: MutableState<Boolean> = mutableStateOf(false)
    val userDataUpdateState: State<Boolean>
        get() = _userDataUpdateState

    protected fun onDataInsertedSuccess() {
        _userDataUpdateState.value = true
    }

    protected fun onDataInsertedError() {
        _userDataUpdateState.value = false
    }
}