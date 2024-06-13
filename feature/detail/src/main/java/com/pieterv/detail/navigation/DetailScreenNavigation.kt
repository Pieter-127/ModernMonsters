package com.pieterv.detail.navigation

@kotlinx.serialization.Serializable
data class DetailScreenRoute(
    val pokemonName: String,
    val imageUrl: String,
)