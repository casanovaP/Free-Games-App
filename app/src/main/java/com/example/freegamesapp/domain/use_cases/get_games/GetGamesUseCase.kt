package com.example.freegamesapp.domain.use_cases.get_games

import com.example.freegamesapp.domain.models.Game
import com.example.freegamesapp.domain.models.toGame
import com.example.freegamesapp.domain.repository.GamesRepository
import javax.inject.Inject

class GetGamesUseCase @Inject constructor(
    private val repository: GamesRepository
) {
    suspend operator fun invoke(): List<Game> {
        return repository.getGames().map { it.toGame() }
    }
}