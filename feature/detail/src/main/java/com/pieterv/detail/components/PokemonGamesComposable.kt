package com.pieterv.detail.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pieterv.detail.R

@Composable
internal fun PokemonGamesComposable(modifier: Modifier = Modifier, games: List<String>) {
    Column(modifier = modifier) {
        Text(
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
            ),
            text = stringResource(id = R.string.found_in_games)
        )
        GamesComposable(modifier = Modifier.padding(top = 8.dp), games = games)
    }
}

@Composable
private fun GamesComposable(modifier: Modifier = Modifier, games: List<String>) {
    Column(modifier = modifier) {
        games.chunked(2).forEach { pair ->
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                pair.forEach { game ->
                    StaggeredBox(
                        gameName = game, modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(10.dp))
                    )
                }
                if (pair.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}

@Composable
private fun StaggeredBox(modifier: Modifier = Modifier, gameName: String) {
    Box(
        modifier = modifier
            .padding(horizontal = 6.dp, vertical = 4.dp)
            .shadow(2.dp, RoundedCornerShape(10.dp))
            .clip(RoundedCornerShape(10.dp))
            .background(MaterialTheme.colorScheme.surface)
    )
    {
        Text(
            modifier = Modifier.padding(8.dp),
            text = gameName,
            style = TextStyle(
                fontSize = 20.sp
            ),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )
    }
}