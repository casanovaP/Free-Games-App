package com.example.freegamesapp.presentation.screens.home_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.example.freegamesapp.domain.models.Game
import com.example.freegamesapp.navigation.Screen
import com.example.freegamesapp.presentation.screens.components.GameCard

@Composable
fun GamesUiList(
    games: List<Game>,
    navController: NavController,
    modifier: Modifier
) {
    LazyColumn(
        modifier.fillMaxSize()
    ) {
        items(games) { game ->
            GameCard(
                game = game,
                onItemClick = {
                navController.navigate(Screen.GameDetailsScreen.passGameId(game.id))
            },
                navController = navController
            )
        }
    }
}