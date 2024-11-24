package com.app.cvbuilder

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.cvbuilder.core.ui.theme.CvBuilderTheme
import com.app.cvbuilder.navigation.BottomNavigationBar
import com.app.cvbuilder.navigation.CVCreationGraph
import com.app.cvbuilder.navigation.CVCreationStart
import com.app.cvbuilder.navigation.MainNavigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CvBuilderTheme {
                MainScreen()
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val currentGraph =
        navController.currentBackStackEntryAsState().value?.destination?.parent?.route
    val systemBarsPaddings = WindowInsets.systemBars.asPaddingValues()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .padding(systemBarsPaddings),
        bottomBar = {
            if (currentGraph != CVCreationGraph::class.qualifiedName) {
                BottomNavigationBar(navController = navController, onTabSelected = { route ->
                    navController.navigate(route)
                })
            }
        }
    ) {
        MainNavigation(navController = navController)
    }
}