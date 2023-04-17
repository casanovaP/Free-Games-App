package com.example.freegamesapp.presentation.screens.home_screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freegamesapp.domain.models.Game
import com.example.freegamesapp.domain.use_cases.UseCases
import com.example.freegamesapp.domain.use_cases.get_games.GetGamesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val useCases: UseCases
) : ViewModel() {

    var homeUiState: HomeUiState by mutableStateOf(HomeUiState.Loading)
        private set

    init {
        getAllGames()
    }

    fun getAllGames() {
        viewModelScope.launch {
            homeUiState = HomeUiState.Loading
            homeUiState = try {
                HomeUiState.Success(useCases.getGamesUseCase())
            } catch (e: IOException) {
                HomeUiState.Error("Loading Failed. Please check your internet connection")
            } catch (e: HttpException) {
                HomeUiState.Error("An unexpected error occurred")
            }
        }
    }
}