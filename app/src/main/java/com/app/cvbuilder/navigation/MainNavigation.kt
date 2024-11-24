package com.app.cvbuilder.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.app.cvbuilder.main_screens.cv_creation.cv_create_starting_screen.presentation.CVCreationStartingScreen
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.certificate.presentation.UserCertificatesScreen
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.choose_photo.presentation.UserChoosePhotoScreen
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.companies.presentation.UserCompaniesScreen
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.contacts.presentation.UserContactsScreen
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.education.presentation.UserEducationScreen
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.initials.presentation.UserInitialsScreen
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.skills.presentation.UserSkillsScreen
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.sumary.presentation.UserSummaryScreen
import com.app.cvbuilder.main_screens.cv_creation.cv_user_data.presentation.work_experience.presentation.UserWorkExperienceScreen
import com.app.cvbuilder.main_screens.bottom_bar.home.presentation.HomeScreen
import com.app.cvbuilder.main_screens.bottom_bar.settings.presentation.SettingsScreen
import com.app.cvbuilder.main_screens.bottom_bar.templates.presentation.TemplatesScreen
import com.app.cvbuilder.main_screens.bottom_bar.user.presentation.UserScreen

@Composable
fun MainNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Home) {
        composable<Home> {
            HomeScreen(navController = navController)
        }
        composable<Templates> {
            TemplatesScreen()
        }
        composable<Settings> {
            SettingsScreen()
        }
        cvCreationGraph(navController)
    }
}

fun NavGraphBuilder.cvCreationGraph(
    navController: NavController
) {
    this.navigation<CVCreationGraph>(startDestination = CVCreationStart) {
        composable<CVCreationStart> {
            CVCreationStartingScreen(
                onNextButtonClick = {
                    navController.navigate(UserInitials)
                }, onPreviousButtonClick = {
                    navController.navigate(Home)
                })
        }
        composable<UserInitials> {
            UserInitialsScreen(
                onNextButtonClicked = {
                    navController.navigate(UserWorkExperience)
                }, onPreviousButtonClick = {
                    navController.navigate(CVCreationStart)
                })
        }
        composable<UserWorkExperience> {
            UserWorkExperienceScreen(
                onNextButtonClick = {
                    navController.navigate(UserCompanies)
                }, onPreviousButtonClick = {
                    navController.navigate(UserInitials)
                })
        }
        composable<UserCompanies> {
            UserCompaniesScreen(
                onNextButtonClick = {
                    navController.navigate(UserSkills)
                }, onPreviousButtonClick = {
                    navController.navigate(UserWorkExperience)
                })
        }
        composable<UserSkills> {
            UserSkillsScreen(
                onNextButtonClick = {
                    navController.navigate(UserEducation)
                }, onPreviousButtonClick = {
                    navController.navigate(UserCompanies)
                })
        }
        composable<UserEducation> {
            UserEducationScreen(
                onNextButtonClick = {
                    navController.navigate(UserCertificate)
                }, onPreviousButtonClick = {
                    navController.navigate(UserSkills)
                })
        }
        composable<UserCertificate> {
            UserCertificatesScreen(
                onNextButtonClick = {
                    navController.navigate(UserChoosePhoto)
                }, onPreviousButtonClick = {
                    navController.navigate(UserEducation)
                })
        }
        composable<UserChoosePhoto> {
            UserChoosePhotoScreen(
                onNextButtonClicked = {
                    navController.navigate(UserContacts)
                }, onPreviousButtonClick = {
                    navController.navigate(UserCertificate)
                })
        }
        composable<UserContacts> {
            UserContactsScreen(
                onNextButtonClick = {
                    navController.navigate(UserSummary)
                }, onPreviousButtonClick = {
                    navController.navigate(UserChoosePhoto)
                })
        }
        composable<UserSummary> {
            UserSummaryScreen(
                onNextButtonClick = {

                }, onPreviousButtonClick = {
                    navController.navigate(UserContacts)
                })
        }
    }
}