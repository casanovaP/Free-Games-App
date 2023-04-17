package com.example.freegamesapp.navigation

sealed class Screen(val route: String){
    object GamesListScreen: Screen("games_list_screen")
    object GameDetailsScreen: Screen("games_details_screen/{gameId}") {
        fun passGameId(gameId: Int): String {
            return "games_details_screen/$gameId"
        }
    }
}
