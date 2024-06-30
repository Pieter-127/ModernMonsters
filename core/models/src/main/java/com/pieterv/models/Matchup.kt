package com.pieterv.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Serializable
@Parcelize
enum class Matchup : Parcelable {
    BUG, DARK, DRAGON, ELECTRIC, FAIRY, FIGHTING, FIRE, FLYING,
    GHOST, GRASS, GROUND, ICE, NORMAL, POISON, PSYCHIC, ROCK, STEEL, WATER
}