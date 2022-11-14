package com.grayseal.notesapp.navigation

enum class NoteScreens {
    SplashScreen,
    WelcomeScreen,
    HomeScreen,
    NoteScreen;
    companion object {
        fun fromRoute(route: String?): NoteScreens
        = when (route?.substringBefore("/")) {
            SplashScreen.name -> SplashScreen
            WelcomeScreen.name -> WelcomeScreen
            HomeScreen.name -> HomeScreen
            NoteScreen.name -> NoteScreen
            null -> HomeScreen
            else -> throw IllegalArgumentException("Route $route is not recognized")
        }
    }
}