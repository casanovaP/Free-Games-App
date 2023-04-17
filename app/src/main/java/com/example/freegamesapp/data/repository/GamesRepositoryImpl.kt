package com.example.freegamesapp.data.repository

import com.example.freegamesapp.data.models.GameDto
import com.example.freegamesapp.data.remote.GamesApi
import com.example.freegamesapp.domain.repository.GamesRepository
import javax.inject.Inject

class GamesRepositoryImpl @Inject constructor(
    private val api: GamesApi
): GamesRepository {
    override suspend fun getGames(): List<GameDto> {
        return api.getGames()
    }
    override suspend fun getGameById(gameId: Int): GameDto {
        return api.getGameById(gameId)
    }
}