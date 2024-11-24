package com.app.cvbuilder.navigation

import android.util.Log
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import com.app.cvbuilder.R
import com.app.cvbuilder.core.ui.theme.PrimaryColorLight
import com.app.cvbuilder.core.ui.theme.PrimaryColorPurple
import com.app.cvbuilder.core.ui.theme.PurpleColorDark
import com.app.cvbuilder.core.ui.theme.RedColor
import com.app.cvbuilder.core.ui.theme.SecondaryColorPurple
import kotlinx.serialization.Serializable

@Serializable
data object Home

@Serializable
data object Templates

@Serializable
data object User

@Serializable
data object Settings

@Serializable
data object CVCreationGraph

@Serializable
data object CVCreationStart

@Serializable
data object UserCertificate

@Serializable
data object UserChoosePhoto

@Serializable
data object UserContacts

@Serializable
data object UserEducation

@Serializable
data object UserInitials

@Serializable
data object UserSkills

@Serializable
data object UserSummary

@Serializable
data object UserWorkExperience

@Serializable
data object UserCompanies

@Serializable
data object CVTemplates

data class TopLevelRoute<T : Any>(val name: String, val route: T, val icon: Int)


@Composable
fun BottomNavigationBar(navController: NavController, onTabSelected: (Any) -> Unit) {

    val topLevelRoutes = listOf(
        TopLevelRoute("Home", Home, R.drawable.ic_dashboard),
        TopLevelRoute("Templates", Templates, R.drawable.ic_description),
        TopLevelRoute("Settings", Settings, R.drawable.ic_settings)
    )

    BottomNavigation(
        modifier = Modifier
            .padding(bottom = 30.dp, start = 20.dp, end = 20.dp)
            .clip(RoundedCornerShape(30.dp))
            .height(70.dp)
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        topLevelRoutes.forEach { topLevelRoute ->

            val isSelected =
                currentDestination?.hierarchy?.any { it.hasRoute(topLevelRoute.route::class) }
                    ?: false

            val width by animateDpAsState(targetValue = if (isSelected) 120.dp else 80.dp)

            BottomNavigationItem(
                modifier = Modifier
                    .padding(8.dp)
                    .clip(RoundedCornerShape(20.dp))
                    .width(width)
                    .background(if (isSelected) PrimaryColorLight else SecondaryColorPurple),
                icon = {
                    Icon(
                        painter = painterResource(id = topLevelRoute.icon),
                        contentDescription = topLevelRoute.name
                    )
                },
                selectedContentColor = RedColor,
                unselectedContentColor = PrimaryColorLight,
                label = { Text(topLevelRoute.name) },
                selected = isSelected,
                onClick = {
                    onTabSelected.invoke(topLevelRoute.route)
                }
            )
        }
    }
}