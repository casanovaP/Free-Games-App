package com.example.freegamesapp.domain.models

import com.example.freegamesapp.data.models.GameDto


data class GameDetails(
    val id: Int,
    val thumbnail: String,
    val title: String,
    val developer: String,
    val freeToGameProfileUrl: String,
    val gameUrl: String,
    val genre: String,
    val platform: String,
    val publisher: String,
    val releaseDate: String,
    val shortDescription: String
)

fun GameDto.toGameDetails(): GameDetails {
    return GameDetails(
        id = id,
    thumbnail = thumbnail,
    title = title,
    developer = developer,
    freeToGameProfileUrl = freeToGameProfileUrl,
    gameUrl = gameUrl,
    genre = genre,
    platform = platform,
    publisher = publisher,
    releaseDate = releaseDate,
    shortDescription = shortDescription
    )
}
