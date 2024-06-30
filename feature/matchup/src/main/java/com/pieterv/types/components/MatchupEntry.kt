package com.pieterv.types.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.pieterv.common.formatToDisplayCase
import com.pieterv.models.Matchup
import java.util.Locale

@Composable
internal fun MatchupEntry(
    entry: Matchup,
    modifier: Modifier = Modifier,
    onMatchupTap: (Matchup) -> Unit
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
                onMatchupTap.invoke(entry)
            }
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = entry.name.formatToDisplayCase(),
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}