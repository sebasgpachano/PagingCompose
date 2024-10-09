package com.example.pagingcompose.presentation.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage

@Composable
fun DetailsScreen(detailsViewModel: DetailsViewModel = hiltViewModel(), characterId: String?) {

    val details = detailsViewModel.detailsStateFlow.collectAsState().value

    LaunchedEffect(characterId) {
        characterId?.toIntOrNull()?.let { id ->
            detailsViewModel.fetchCharacter(id)
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        details?.let { details ->
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                AsyncImage(
                    model = details.image, contentDescription = null,
                    modifier = Modifier.size(250.dp),
                    contentScale = ContentScale.Crop
                )
                Text(text = "Nombre: ${details.name}", color = Color.White, fontSize = 24.sp)
                Text(text = "Status: ${details.status}", color = Color.White, fontSize = 18.sp)
                Text(text = "Especie: ${details.species}", color = Color.White, fontSize = 18.sp)
                Text(text = "Género: ${details.gender}", color = Color.White, fontSize = 18.sp)
            }
        } ?: run {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator(color = Color.White)
            }
        }
    }
}