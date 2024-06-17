package com.pieterv.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import java.util.Locale

@Composable
internal fun PokemonTypesComposable(
    modifier: Modifier = Modifier,
    types: List<String>
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
    ) {

        if (types.isEmpty()) {
            return@Row
        }
        if (types.size == 1) {
            TypeCard(
                text = types.first(),
                textColor = determineTextColor(types.first()),
                backgroundColor = determineBackgroundColor(types.first())
            )
        } else {
            types.forEach { type ->
                TypeCard(
                    text = type,
                    textColor = determineTextColor(type),
                    backgroundColor = determineBackgroundColor(type)
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}

private fun determineBackgroundColor(type: String): Color {
    val colours = mapOf(
        "normal" to Color(0xFFA8A77A),
        "fire" to Color(0xFFEE8130),
        "water" to Color(0xFF6390F0),
        "electric" to Color(0xFFF7D02C),
        "grass" to Color(0xFF7AC74C),
        "ice" to Color(0xFF96D9D6),
        "fighting" to Color(0xFFC22E28),
        "poison" to Color(0xFFA33EA1),
        "ground" to Color(0xFFE2BF65),
        "flying" to Color(0xFF66B5FA),
        "psychic" to Color(0xFFF95587),
        "bug" to Color(0xFFA6B91A),
        "rock" to Color(0xFFB6A136),
        "ghost" to Color(0xFF735797),
        "dragon" to Color(0xFF6F35FC),
        "dark" to Color(0xFF705746),
        "steel" to Color(0xFFB7B7CE),
        "fairy" to Color(0xFFD685AD)
    )

    return colours[type.lowercase(Locale.US)] ?: Color.White
}

//adding this to potentially make content more readable
private fun determineTextColor(type: String): Color {
    val colours = mapOf(
        "normal" to Color.Black,
        "fire" to Color.White,
        "water" to Color.White,
        "electric" to Color.Black,
        "grass" to Color.White,
        "ice" to Color.Black,
        "fighting" to Color.White,
        "poison" to Color.White,
        "ground" to Color.Black,
        "flying" to Color.Black,
        "psychic" to Color.White,
        "bug" to Color.Black,
        "rock" to Color.Black,
        "ghost" to Color.White,
        "dragon" to Color.White,
        "dark" to Color.White,
        "steel" to Color.Black,
        "fairy" to Color.Black,
    )

    return colours[type.lowercase(Locale.US)] ?: Color.White
}


@Composable
private fun TypeCard(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color,
    textColor: Color
) {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor,
        ),
        modifier = modifier
            .padding(4.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Row(
            modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                color = textColor,
                text = text,
            )
        }
    }
}

@Preview
@Composable
private fun ChipCardPreview() {
    PokemonTypesComposable(
        modifier = Modifier.fillMaxWidth(),
        types = listOf("dark", "dragon")
    )
}