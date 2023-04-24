package com.example.freegamesapp.presentation.screens.details_screen

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.freegamesapp.R
import com.example.freegamesapp.domain.models.GameDetails
import com.example.freegamesapp.presentation.screens.home_screen.HomeViewModel
import com.example.freegamesapp.utils.Constants

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FreeGamesDetailsScreen(
    gameid: Int,
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = { TopAppBar(title = { Text(stringResource(R.string.app_name)) }) }
    ) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(4.dp),
            color = MaterialTheme.colorScheme.background
        ) {
            val detailsViewModel: DetailsViewModel = viewModel()

            DetailsState(gameId = gameid)
        }
    }
}