package com.pieterv.detail.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.pieterv.detail.R

@Composable
internal fun PokemonStatsComposable(modifier: Modifier = Modifier, baseStats: Int) {
    val annotatedString = buildAnnotatedString {
        val firstHalf = stringResource(id = R.string.base_stats)
        append(firstHalf)

        addStyle(
            style = SpanStyle(
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            ), start = 0, end = firstHalf.length
        )

        val secondHalf = baseStats.toString()

        append(secondHalf)
        addStyle(
            style = SpanStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            ), start = firstHalf.length, end = firstHalf.length + secondHalf.length
        )
    }

    Text(
        modifier = modifier,
        text = annotatedString
    )
}

@Composable
@Preview(showBackground = true)
private fun PreviewStatsComposable() {
    PokemonStatsComposable(modifier = Modifier.fillMaxWidth(), 35)
}