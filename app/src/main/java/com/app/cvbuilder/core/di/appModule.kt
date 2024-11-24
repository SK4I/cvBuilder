package com.app.cvbuilder.core.di

import com.app.cvbuilder.main_screens.cv_creation.cv_create_starting_screen.data.UserCVNameRepository
import com.app.cvbuilder.main_screens.cv_creation.cv_create_starting_screen.data.UserCVNameRepositoryImpl
import com.app.cvbuilder.main_screens.cv_creation.cv_create_starting_screen.presentation.UserCVNameViewModel
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.initials.data.UserInitialsRepository
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.initials.data.UserInitialsRepositoryImpl
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.initials.presentation.UserInitialsViewModel
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.language.data.CVLanguageRepository
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.language.data.CVLanguageRepositoryImpl
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.language.presentation.CVLanguageViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val appModule = module {

    single<UserInitialsRepository> { UserInitialsRepositoryImpl() }
    single<UserCVNameRepository> { UserCVNameRepositoryImpl() }
    single<CVLanguageRepository> { CVLanguageRepositoryImpl() }

    viewModelOf(::UserInitialsViewModel)
    viewModelOf(::UserCVNameViewModel)
    viewModelOf(::CVLanguageViewModel)
}