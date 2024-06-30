package com.pieterv.common

import java.util.Locale

fun String.formatToDisplayCase(): String {
    return this.lowercase(Locale.US)
        .replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString()
        }
}