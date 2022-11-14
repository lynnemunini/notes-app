package com.grayseal.notesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.grayseal.notesapp.screens.HomeScreen
import com.grayseal.notesapp.screens.NoteScreen
import com.grayseal.notesapp.screens.SplashScreen
import com.grayseal.notesapp.screens.WelcomeScreen

@Composable
fun NoteNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NoteScreens.SplashScreen.name){
        composable(NoteScreens.SplashScreen.name) {
            SplashScreen(navController = navController)
        }
        composable(NoteScreens.WelcomeScreen.name) {
            // Pass where this should lead user to
            WelcomeScreen(navController = navController)            
        }
        composable(NoteScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        } 
        composable(NoteScreens.NoteScreen.name) {
            NoteScreen(navController = navController)
        }

    }
}