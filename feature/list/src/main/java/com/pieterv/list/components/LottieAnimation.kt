package com.pieterv.list.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.SubcomposeAsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.pieterv.list.R
import com.pieterv.models.PokemonListEntry



@Composable
internal fun LoaderAnimation() {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.anim))
    LottieAnimation(
        composition,
        isPlaying = true,
    )
}