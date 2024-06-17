package com.pieterv.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.pieterv.components.ImageLoadingComposable
import com.pieterv.detail.R

@Composable
fun PokemonSpritesComposable(modifier: Modifier = Modifier, sprites: List<String>) {
    LazyRow(modifier = modifier, contentPadding = PaddingValues(8.dp)) {
        items(sprites) { spriteUrl ->
            Box(
                modifier = modifier
                    .padding(horizontal = 6.dp, vertical = 8.dp)
                    .shadow(5.dp, RoundedCornerShape(10.dp))
                    .clip(RoundedCornerShape(10.dp))
                    .aspectRatio(1f)
                    .background(MaterialTheme.colorScheme.surface)
            )
            {
                ImageLoadingComposable(modifier = Modifier.size(120.dp),
                    imageUrl = spriteUrl,
                    contentDescription = spriteUrl,
                    loadingAnimation = {
                        LottieAnimation(R.raw.anim, true)
                    })
            }
        }
    }
}