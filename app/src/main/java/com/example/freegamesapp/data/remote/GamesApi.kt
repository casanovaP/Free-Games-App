package com.example.freegamesapp.data.remote

import com.example.freegamesapp.data.models.GameDto
import com.example.freegamesapp.utils.Constants
import retrofit2.http.GET
import retrofit2.http.Path

interface GamesApi {
    @GET(Constants.GAMES_ENDPOINT)
    suspend fun getGames(): List<GameDto>

    @GET(Constants.GAME_DETAILS+"{gameId}")
    suspend fun getGameById(@Path("gameId") gameId: Int): GameDto
}