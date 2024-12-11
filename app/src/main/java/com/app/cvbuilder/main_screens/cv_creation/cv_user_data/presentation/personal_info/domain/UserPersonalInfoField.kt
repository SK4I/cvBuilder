package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.personal_info.domain

data class UserPersonalInfoField(
    val title: String,
    val value: String = "",
    val sectionType: UserPersonalInfoSectionType,
    val infoType: UserPersonalInfoType
)

sealed class UserPersonalInfoSectionType {
    data object Main : UserPersonalInfoSectionType()
    data object ContactInfo : UserPersonalInfoSectionType()
    data object Address : UserPersonalInfoSectionType()
}

sealed class UserPersonalInfoType {
    data object FullName: UserPersonalInfoType()
    data object DateOfBirth: UserPersonalInfoType()
    data object Email: UserPersonalInfoType()
    data object PhoneNumber: UserPersonalInfoType()
    data object Website: UserPersonalInfoType()
    data object Address: UserPersonalInfoType()
    data object PostalCode: UserPersonalInfoType()
    data object City: UserPersonalInfoType()
    data object Region: UserPersonalInfoType()
    data object Country: UserPersonalInfoType()
}