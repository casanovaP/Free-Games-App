package com.example.freegamesapp.presentation.screens.details_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freegamesapp.domain.use_cases.UseCases
import com.example.freegamesapp.domain.use_cases.get_game.GetGameUseCase
import com.example.freegamesapp.utils.Constants
import com.example.freegamesapp.utils.Constants.GAME_PARAM_KEY
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCases: UseCases,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    var detailsUiState by mutableStateOf<DetailsUiState>(DetailsUiState.Loading)
        private set

    init {
        savedStateHandle.get<Int>(GAME_PARAM_KEY)?.let { gameId ->
            getGame(gameId)
        }
    }

    fun getGame(gameId: Int) {
        viewModelScope.launch {
            detailsUiState = DetailsUiState.Loading
            detailsUiState = try {
                DetailsUiState.Success(useCases.getGameUseCase(gameId))
            } catch (e: IOException) {
                DetailsUiState.Error("Loading Failed. Please check your internet connection")
            } catch (e: HttpException) {
                DetailsUiState.Error("An unexpected error occurred")
            }
        }
    }
}