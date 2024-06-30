package com.pieterv.data.repository.mapper


import com.pieterv.common.formatToDisplayCase
import com.pieterv.models.PokemonDetail
import com.pieterv.network.model.PokemonDto
import com.pieterv.network.model.Sprites
import java.util.Locale
import kotlin.reflect.full.memberProperties
import kotlin.reflect.jvm.isAccessible

fun PokemonDto.toPokemonDetail(): PokemonDetail {
    return PokemonDetail(
        baseStats = this.stats.firstOrNull()?.base ?: 0,
        foundInGames = this.games.map { game ->
            game.version.name.formatToDisplayCase()
                .replace("-", " ")
        },
        types = this.types.map { typeInfo ->
            typeInfo.type.name.formatToDisplayCase()
        },
        sprites = getAllSpriteResources(sprites)
    )
}

private fun getAllSpriteResources(sprites: Sprites): List<String> {
    //not ideal but keeps order of sprites together through reflection
    val spriteOrder = listOf(
        "backDefault",
        "frontDefault",
        "backFemale",
        "frontFemale",
        "backShiny",
        "frontShiny",
        "backShinyFemale",
        "frontShinyFemale",
    )

    return spriteOrder.mapNotNull { propertyName ->
        Sprites::class.memberProperties
            .find { it.name == propertyName }
            ?.apply { isAccessible = true }
            ?.get(sprites) as? String
    }
}