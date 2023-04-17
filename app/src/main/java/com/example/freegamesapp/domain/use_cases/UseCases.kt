package com.example.freegamesapp.domain.use_cases

import com.example.freegamesapp.domain.use_cases.get_game.GetGameUseCase
import com.example.freegamesapp.domain.use_cases.get_games.GetGamesUseCase

data class UseCases(
    val getGamesUseCase: GetGamesUseCase,
    val getGameUseCase: GetGameUseCase
)
