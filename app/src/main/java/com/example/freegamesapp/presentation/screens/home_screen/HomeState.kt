package com.example.freegamesapp.presentation.screens.home_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.freegamesapp.domain.models.Game
import com.example.freegamesapp.presentation.screens.components.LoadingScreen
import com.example.freegamesapp.presentation.screens.components.ErrorScreen

sealed interface HomeUiState {
    object Loading : HomeUiState
    data class Success(val games: List<Game>) : HomeUiState
    data class Error(val message: String) : HomeUiState
}

@Composable
fun HomeState(
    homeViewModel: HomeViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    val homeUiState = homeViewModel.homeUiState

    when (homeUiState) {
        is HomeUiState.Loading -> LoadingScreen()
        is HomeUiState.Success -> GamesUiList(
            homeUiState.games,
            navController = navController,
            modifier = Modifier,
        )
        is HomeUiState.Error -> ErrorScreen(
            retryAction = { homeViewModel.getAllGames() },
            modifier
        )
    }
}