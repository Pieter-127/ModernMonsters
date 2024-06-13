package com.pieterv.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.SubcomposeAsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest

@Composable
fun ImageLoadingComposable(
    modifier: Modifier,
    imageUrl: String,
    contentDescription: String,
    loadingAnimation: @Composable () -> Unit
) {
    SubcomposeAsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .diskCachePolicy(
                CachePolicy.ENABLED
            )
            .crossfade(true)
            .build(),
        loading = {
            loadingAnimation()
        },
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}