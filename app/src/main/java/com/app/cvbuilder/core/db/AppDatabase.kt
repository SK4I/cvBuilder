package com.app.cvbuilder.core.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.app.cvbuilder.main_screens.cv_creation.cv_create_starting_screen.data.UserCVName
import com.app.cvbuilder.main_screens.cv_creation.cv_create_starting_screen.data.UserCVNameDao
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.certificate.data.UserCertificates
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.certificate.data.UserCertificatesDao
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.choose_photo.data.UserPhoto
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.choose_photo.data.UserPhotoDao
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.companies.data.UserCompanies
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.companies.data.UserCompaniesDao
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.initials.data.UserInitials
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.initials.data.UserInitialsDao
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.language.data.CVLanguageDao
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.language.data.CVLanguageItem

private const val ROOM_VERSION = 1

@Database(
    entities = [
        User::class,
        UserInitials::class,
        UserPhoto::class,
        UserCertificates::class,
        UserCompanies::class,
        UserCVName::class,
        CVLanguageItem::class],
    version = ROOM_VERSION,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userInitialsDao(): UserInitialsDao
    abstract fun userPhotoDao(): UserPhotoDao
    abstract fun userCertificatesDao(): UserCertificatesDao
    abstract fun userCompaniesDao(): UserCompaniesDao
    abstract fun userCVNameDao(): UserCVNameDao
    abstract fun userCVLanguageDao(): CVLanguageDao
}