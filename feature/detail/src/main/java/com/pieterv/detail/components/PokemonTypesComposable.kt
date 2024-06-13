package com.pieterv.detail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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

@Composable
internal fun PokemonTypesComposable(types: ArrayList<String>) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {

        if (types.isEmpty()) {
            return@Row
        }
        if (types.size == 1) {
            TypeCard(
                text = types.first(),
                backgroundColor = Color.Green
            )
        } else {
            types.forEach { type ->
                TypeCard(
                    text = type,
                    backgroundColor = Color.Green
                )
                Spacer(modifier = Modifier.width(16.dp))
            }
        }
    }
}

@Composable
private fun TypeCard(
    modifier: Modifier = Modifier,
    text: String,
    backgroundColor: Color,
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
                text = text,
            )
        }
    }
}

@Preview
@Composable
private fun ChipCardPreview() {
    TypeCard(
        text = "Grass",
        backgroundColor = Color.Green
    )
}