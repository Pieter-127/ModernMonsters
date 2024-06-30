package com.pieterv.design.theme

import androidx.compose.ui.graphics.Color
import com.pieterv.models.Matchup

fun determineColorForType(type: Matchup): Color {
    return when (type) {
        Matchup.NORMAL -> Color(0xFFA8A77A)
        Matchup.FIRE -> Color(0xFFEE8130)
        Matchup.WATER -> Color(0xFF6390F0)
        Matchup.ELECTRIC -> Color(0xFFF7D02C)
        Matchup.GRASS -> Color(0xFF7AC74C)
        Matchup.ICE -> Color(0xFF96D9D6)
        Matchup.FIGHTING -> Color(0xFFC22E28)
        Matchup.POISON -> Color(0xFFA33EA1)
        Matchup.GROUND -> Color(0xFFE2BF65)
        Matchup.FLYING -> Color(0xFF66B5FA)
        Matchup.PSYCHIC -> Color(0xFFF95587)
        Matchup.BUG -> Color(0xFFA6B91A)
        Matchup.ROCK -> Color(0xFFB6A136)
        Matchup.GHOST -> Color(0xFF735797)
        Matchup.DRAGON -> Color(0xFF6F35FC)
        Matchup.DARK -> Color(0xFF705746)
        Matchup.STEEL -> Color(0xFFB7B7CE)
        Matchup.FAIRY -> Color(0xFFD685AD)
        Matchup.NEW -> Color.White
    }
}


//adding this to potentially make content more readable
fun determineTextColorOnType(type: Matchup): Color {
    return when (type) {
        Matchup.NORMAL, Matchup.ELECTRIC, Matchup.ICE, Matchup.GROUND, Matchup.FLYING, Matchup.BUG,
        Matchup.ROCK, Matchup.STEEL -> Color.Black

        Matchup.FIRE, Matchup.WATER, Matchup.GRASS, Matchup.FIGHTING, Matchup.POISON,
        Matchup.PSYCHIC, Matchup.GHOST, Matchup.DRAGON, Matchup.DARK, Matchup.FAIRY -> Color.White

        Matchup.NEW -> Color.Black
    }
}
