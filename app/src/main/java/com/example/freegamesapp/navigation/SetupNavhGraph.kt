package com.example.freegamesapp.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.freegamesapp.presentation.screens.home_screen.FreeGamesAppScreen
import com.example.freegamesapp.utils.Constants.GAME_PARAM_KEY

@Composable
fun SetupNavhGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.GamesListScreen.route
    ) {
        composable(Screen.GamesListScreen.route) {
            FreeGamesAppScreen(navController = navController)
        }

        composable(
            Screen.GameDetailsScreen.route,
            arguments = listOf(navArgument(GAME_PARAM_KEY) {
                type = NavType.IntType
            })
        ) {

        }
    }
}