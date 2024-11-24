package com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.contacts.presentation

import androidx.compose.runtime.mutableStateListOf
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.UserDataBaseViewModel
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.contacts.domain.ContactItem
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.contacts.domain.ContactType

class UserContactsViewModel() : UserDataBaseViewModel() {

    val contactTypesList = mutableStateListOf<ContactItem>(
        ContactItem(ContactType.Github, ""),
        ContactItem(ContactType.LinkedIn, ""),
        ContactItem(ContactType.WebSite, ""),
        ContactItem(ContactType.PhoneNumber, ""),
        ContactItem(ContactType.Mail, "")
    )


}