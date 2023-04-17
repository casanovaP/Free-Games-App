package com.example.freegamesapp.presentation.screens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.freegamesapp.domain.models.Game
import com.example.freegamesapp.navigation.Screen


@Composable
fun GameCard(
    game: Game,
    onItemClick: (String) -> Unit,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    Card(
        elevation = CardDefaults.cardElevation(10.dp),
        modifier = modifier
            .fillMaxWidth()
            .padding(all = 8.dp)
            .clip(RoundedCornerShape(10.dp))
            .clickable { onItemClick(Screen.GameDetailsScreen.route + "/${game.id}") },
    ) {
        Column(
            modifier = modifier
                .fillMaxSize(),
            Arrangement.Center,
            Alignment.CenterHorizontally,
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(game.thumbnail)
                    .crossfade(true)
                    .build(),
                contentDescription = "${game.title} image",
                contentScale = ContentScale.FillBounds
            )

            Spacer(modifier = modifier.height(8.dp))

            Text(text = game.title)
            Text(text = game.releaseDate)
        }
    }
}