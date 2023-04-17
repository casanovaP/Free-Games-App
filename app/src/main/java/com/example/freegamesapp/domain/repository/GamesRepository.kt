package com.example.freegamesapp.domain.repository

import com.example.freegamesapp.data.models.GameDto

interface GamesRepository {
    suspend fun getGames(): List<GameDto>

    suspend fun getGameById(gameId: Int): GameDto
}