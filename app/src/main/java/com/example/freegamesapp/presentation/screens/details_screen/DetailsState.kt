package com.example.freegamesapp.presentation.screens.details_screen

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.freegamesapp.domain.models.GameDetails
import com.example.freegamesapp.presentation.screens.components.LoadingScreen
import com.example.freegamesapp.presentation.screens.components.ErrorScreen

sealed interface DetailsUiState {
    object Loading : DetailsUiState
    data class Success(val game: GameDetails) : DetailsUiState
    data class Error(val message: String) : DetailsUiState
}

@Composable
fun DetailsState(
    detailsViewModel: DetailsViewModel,
    modifier: Modifier = Modifier
) {

    val detailsUiState = detailsViewModel.detailsUiState

    when (detailsUiState) {
        is DetailsUiState.Loading -> LoadingScreen()
        is DetailsUiState.Success -> GameDetailsScreen(detailsUiState.game, modifier)
        is DetailsUiState.Error -> ErrorScreen(
            retryAction = { detailsViewModel },
            modifier
        )
    }
}