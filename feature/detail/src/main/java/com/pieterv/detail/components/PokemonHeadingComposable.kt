package com.pieterv.detail.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pieterv.components.ImageLoadingComposable
import com.pieterv.models.PokemonName

@Composable
internal fun PokemonHeadingImage(
    modifier: Modifier = Modifier,
    pokemonImageUrl: String,
    pokemonName: PokemonName
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Column {
            ImageLoadingComposable(
                modifier = Modifier.size(180.dp),
                imageUrl = pokemonImageUrl,
                contentDescription = pokemonName,
                loadingAnimation = {
                    CircularProgressIndicator()
                }
            )
        }
    }
}