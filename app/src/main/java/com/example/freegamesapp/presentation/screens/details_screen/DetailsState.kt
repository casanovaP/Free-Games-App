package com.example.freegamesapp.presentation.screens.details_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.freegamesapp.domain.models.GameDetails
import com.example.freegamesapp.presentation.screens.common.LoadingScreen
import com.example.freegamesapp.presentation.screens.common.ErrorScreen
import com.example.freegamesapp.utils.Constants

sealed interface DetailsUiState {
    object Loading : DetailsUiState
    data class Success(val game: GameDetails) : DetailsUiState
    data class Error(val message: String) : DetailsUiState
}

@Composable
fun DetailsState(
    gameId: Int,
    modifier: Modifier = Modifier
) {

    val detailsViewModel: DetailsViewModel = viewModel()
    val detailsUiState = detailsViewModel.detailsUiState

    when (detailsUiState) {
        is DetailsUiState.Loading -> LoadingScreen()
        is DetailsUiState.Success -> GameDetailsScreen(detailsUiState.game, modifier)
        is DetailsUiState.Error -> ErrorScreen(
            retryAction = { detailsViewModel.getGame(gameId) },
            modifier
        )
    }
}