package com.pieterv.typeinfo.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun StoryComposable(modifier: Modifier, story: String?) {
    Text(
        modifier = modifier,
        text = story ?: "",
        fontSize = 16.sp,
        fontWeight = FontWeight.Medium
    )

}