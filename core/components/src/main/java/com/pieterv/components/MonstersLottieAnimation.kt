package com.pieterv.components

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition

@Composable
fun MonstersLottieAnimation(file: Int, isPlaying: Boolean) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(file))
    com.airbnb.lottie.compose.LottieAnimation(
        iterations = Int.MAX_VALUE,
        composition = composition,
        isPlaying = isPlaying,
    )
}