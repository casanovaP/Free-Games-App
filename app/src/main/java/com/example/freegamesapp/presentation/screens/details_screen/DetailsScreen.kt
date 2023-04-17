package com.example.freegamesapp.presentation.screens.details_screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.freegamesapp.domain.models.GameDetails

@Composable
fun GameDetailsScreen(
    gameDetails: GameDetails,
    modifier: Modifier
) {
    val viewModel: DetailsViewModel = viewModel()

    Column(
        modifier = modifier
            .fillMaxSize(),
        Arrangement.Center,
        Alignment.CenterHorizontally,
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(gameDetails.thumbnail)
                .crossfade(true)
                .build(),
            contentDescription = "${gameDetails.title} image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.clip(RoundedCornerShape(10.dp))
        )
        Text("Title: ${gameDetails.title}")
        Text("Genre: ${gameDetails.genre}")
        Text("Platform: ${gameDetails.platform}")
        Text("Developer: ${gameDetails.developer}")
        Text("Publisher: ${gameDetails.publisher}")
        Text("Release date: ${gameDetails.releaseDate}")
        Text("Free to game: ${gameDetails.freeToGameProfileUrl}")
        Text("Game Link: ${gameDetails.gameUrl}")
        Text("Description: ${gameDetails.shortDescription}")
    }
}