package com.grayseal.notesapp.navigation

import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.grayseal.notesapp.screens.*

@Composable
fun NoteNavigation() {
    val navController = rememberNavController()
    val noteViewModel = viewModel<NoteViewModel>()
    NavHost(navController = navController, startDestination = NoteScreens.SplashScreen.name) {
        composable(NoteScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(NoteScreens.WelcomeScreen.name) {
            // Pass where this should lead user to
            WelcomeScreen(navController = navController)
        }
        composable(NoteScreens.HomeScreen.name) {
            HomeScreen(navController = navController, noteViewModel)
        }
        composable(NoteScreens.NoteScreen.name) {
            NoteScreen(navController = navController, noteViewModel)
        }

    }
}