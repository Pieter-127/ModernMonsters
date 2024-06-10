package com.pieterv.list.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pieterv.list.MainScreenEvent
import com.pieterv.models.PokemonListEntry

@Composable
internal fun PokedexEntry(
    entry: PokemonListEntry,
    modifier: Modifier = Modifier,
    event: (MainScreenEvent) -> Unit
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .padding(horizontal = 6.dp, vertical = 8.dp)
            .shadow(5.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .aspectRatio(1f)
            .background(MaterialTheme.colorScheme.surface)
            .clickable {
                event.invoke(MainScreenEvent.PokedexTap(entry))
            }
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            ImageLoadingComposable(
                modifier = Modifier
                    .size(120.dp)
                    .align(Alignment.CenterHorizontally), entry = entry
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = entry.pokemonName,
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = entry.number,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}