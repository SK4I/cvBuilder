package com.app.cvbuilder.core.utils

import com.app.cvbuilder.R
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.contacts.domain.ContactType

fun ContactType.toContactTitle(resourceProvider: ResourceProvider): String {
    when (this) {
        ContactType.Mail -> {
            return resourceProvider.getString(R.string.mail)
        }

        ContactType.Github -> {
            return resourceProvider.getString(R.string.github)
        }

        ContactType.LinkedIn -> {
            return resourceProvider.getString(R.string.linkedin)
        }

        ContactType.PhoneNumber -> {
            return resourceProvider.getString(R.string.phone_number)
        }

        ContactType.WebSite -> {
            return resourceProvider.getString(R.string.web_site)
        }
    }
}