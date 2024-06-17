package com.pieterv.detail.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
internal fun LottieAnimation(file: Int, isPlaying: Boolean) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(file))
    LottieAnimation(
        iterations = Int.MAX_VALUE,
        composition = composition,
        isPlaying = isPlaying,
    )
}