package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.personal_info.presentation

import androidx.compose.runtime.mutableStateListOf
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.UserDataBaseViewModel
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.personal_info.domain.UserPersonalInfoField
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.personal_info.domain.UserPersonalInfoSectionType
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.personal_info.domain.UserPersonalInfoType

class UserPersonalInfoViewModel : UserDataBaseViewModel() {

    val userPersonalInfoFieldsList = mutableStateListOf<UserPersonalInfoField>()

    init {
        userPersonalInfoFieldsList.clear()
        getUserInfoFieldsList()
    }

    private fun getUserInfoFieldsList() {
        val infoFieldsList = listOf(
            UserPersonalInfoField(
                title = "title",
                sectionType = UserPersonalInfoSectionType.ContactInfo,
                infoType = UserPersonalInfoType.FullName
            ),
            UserPersonalInfoField(
                title = "title",
                sectionType = UserPersonalInfoSectionType.Main,
                infoType = UserPersonalInfoType.FullName
            ),
            UserPersonalInfoField(
                title = "title",
                sectionType = UserPersonalInfoSectionType.Address,
                infoType = UserPersonalInfoType.FullName
            ), UserPersonalInfoField(
                title = "title",
                sectionType = UserPersonalInfoSectionType.ContactInfo,
                infoType = UserPersonalInfoType.FullName
            )
        )

        userPersonalInfoFieldsList.addAll(infoFieldsList)
    }

    fun onUserPersonalInfoFieldUpdated(updatedItem: UserPersonalInfoField) {
        updateUserPersonalInfoItem(updatedItem)
    }

    private fun updateUserPersonalInfoItem(updatedItem: UserPersonalInfoField) {
        when (updatedItem.infoType) {
            UserPersonalInfoType.Address -> {
                TODO()
            }

            UserPersonalInfoType.City -> {
                TODO()
            }

            UserPersonalInfoType.Country -> {
                TODO()
            }

            UserPersonalInfoType.DateOfBirth -> {
                TODO()
            }

            UserPersonalInfoType.Email -> {
                TODO()
            }

            UserPersonalInfoType.FullName -> {
                TODO()
            }

            UserPersonalInfoType.PhoneNumber -> {
                TODO()
            }

            UserPersonalInfoType.PostalCode -> {
                TODO()
            }

            UserPersonalInfoType.Region -> {
                TODO()
            }

            UserPersonalInfoType.Website -> {
                TODO()
            }
        }
    }
}