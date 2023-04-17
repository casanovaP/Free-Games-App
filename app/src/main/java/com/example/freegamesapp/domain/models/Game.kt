package com.example.freegamesapp.domain.models

import com.example.freegamesapp.data.models.GameDto

data class Game(
    val id: Int,
    val thumbnail: String,
    val title: String,
    val releaseDate: String
)

fun GameDto.toGame(): Game {
    return Game(
        id = id,
        thumbnail = thumbnail,
        title = title,
        releaseDate = releaseDate
    )
}
