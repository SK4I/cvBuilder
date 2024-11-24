package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.contacts.domain

data class ContactItem(
    val contactType: ContactType,
    val contactContent: String
)

sealed interface ContactType {
    data object LinkedIn : ContactType
    data object PhoneNumber : ContactType
    data object Github : ContactType
    data object WebSite : ContactType
    data object Mail: ContactType
}