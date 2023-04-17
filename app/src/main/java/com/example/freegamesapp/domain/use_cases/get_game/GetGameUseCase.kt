package com.example.freegamesapp.domain.use_cases.get_game

import com.example.freegamesapp.domain.models.GameDetails
import com.example.freegamesapp.domain.models.toGameDetails
import com.example.freegamesapp.domain.repository.GamesRepository
import javax.inject.Inject

class GetGameUseCase @Inject constructor(
    private val repository: GamesRepository
) {
    suspend operator fun invoke(id: Int): GameDetails {
        return repository.getGameById(id).toGameDetails()
    }
}