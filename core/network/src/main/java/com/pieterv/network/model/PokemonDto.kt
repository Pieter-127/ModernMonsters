package com.pieterv.network.model

import com.squareup.moshi.Json

data class PokemonDto(
    val id: Int,
    val name: String,
    @field:Json(name = "game_indices")
    val games: List<Game>,
    @field:Json(name = "location_area_encounters")
    val locationAreaEncounters: String,
    val sprites: Sprites,
    val types: Sprites,
)

data class Game(
    @field:Json(name = "game_index")
    val gameIndex: Int,
    val version: Version
)

data class Version(
    val name: String,
    val url: String
)

data class Sprites(
    @field:Json(name = "back_default")
    val backDefault: String,
    @field:Json(name = "back_female")
    val backFemale: Any,
    @field:Json(name = "back_shiny")
    val backShiny: String,
    @field:Json(name = "back_shiny_female")
    val backShinyFemale: Any,
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_female")
    val frontFemale: Any,
    @field:Json(name = "front_shiny")
    val frontShiny: String,
    @field:Json(name = "front_shiny_female")
    val frontShinyFemale: Any,
    val other: Other,
    val versions: Versions
)

data class Other(
    @field:Json(name = "dream_world")
    val dreamWorld: DreamWorld,
    @field:Json(name = "official-artwork")
    val officialArtwork: OfficialArtwork
)

data class OfficialArtwork(
    @field:Json(name = "front_default")
    val frontDefault: String
)

data class Versions(
    @field:Json(name = "generation-i")
    val generationI: GenerationI,
    @field:Json(name = "generation-ii")
    val generationIi: GenerationIi,
    @field:Json(name = "generation-iii")
    val generationIii: GenerationIii,
    @field:Json(name = "generation-iv")
    val generationIv: GenerationIv,
    @field:Json(name = "generation-v")
    val generationV: GenerationV,
    @field:Json(name = "generation-vi")
    val generationVi: GenerationVi,
    @field:Json(name = "generation-vii")
    val generationVii: GenerationVii,
    @field:Json(name = "generation-viii")
    val generationViii: GenerationViii
)

data class DreamWorld(
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_female")
    val frontFemale: Any
)

data class GenerationI(
    @field:Json(name = "red-blue")
    val redBlue: RedBlue,
    val yellow: Yellow
)

data class GenerationIi(
    val crystal: Crystal,
    val gold: Gold,
    val silver: Silver
)

data class GenerationIii(
    val emerald: Emerald,
    @field:Json(name = "firered-leafgreen")
    val fireRedLeafGreen: FireRedLeafGreen,
    @field:Json(name = "ruby-sapphire")
    val rubySapphire: RubySapphire
)

data class GenerationIv(
    @field:Json(name = "diamond-pearl")
    val diamondPearl: DiamondPearl,
    @field:Json(name = "heartgold-soulsilver")
    val heartGoldSoulSilver: HeartGoldSoulSilver,
    val platinum: Platinum
)

data class GenerationV(
    @field:Json(name = "black-white")
    val blackWhite: BlackWhite
)

data class GenerationVi(
    @field:Json(name = "omegaruby-alphasapphire")
    val omegaRubyAlphaSapphire: OmegaRubyAlphaSapphire,
    @field:Json(name = "x-y")
    val xY: XY
)

data class GenerationVii(
    val icons: Icons,
    @field:Json(name = "ultra-sun-ultra-moon")
    val ultraSunUltraMoon: UltraSunUltraMoon
)

data class GenerationViii(
    val icons: IconsX
)

data class RedBlue(
    @field:Json(name = "back_default")
    val backDefault: String,
    @field:Json(name = "back_gray")
    val backGray: String,
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_gray")
    val frontGray: String
)

data class Yellow(
    @field:Json(name = "back_default")
    val backDefault: String,
    @field:Json(name = "back_gray")
    val backGray: String,
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_gray")
    val frontGray: String
)


data class DiamondPearl(
    @field:Json(name = "back_default")
    val backDefault: String,
    @field:Json(name = "back_female")
    val backFemale: Any,
    @field:Json(name = "back_shiny")
    val backShiny: String,
    @field:Json(name = "back_shiny_female")
    val backShinyFemale: Any,
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_female")
    val frontFemale: Any,
    @field:Json(name = "front_shiny")
    val frontShiny: String,
    @field:Json(name = "front_shiny_female")
    val frontShinyFemale: Any
)

data class BlackWhite(
    val animated: Animated,
    @field:Json(name = "back_default")
    val backDefault: String,
    @field:Json(name = "back_female")
    val backFemale: Any,
    @field:Json(name = "back_shiny")
    val backShiny: String,
    @field:Json(name = "back_shiny_female")
    val backShinyFemale: Any,
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_female")
    val frontFemale: Any,
    @field:Json(name = "front_shiny")
    val frontShiny: String,
    @field:Json(name = "front_shiny_female")
    val frontShinyFemale: Any
)

data class Crystal(
    @field:Json(name = "back_default")
    val backDefault: String,
    @field:Json(name = "back_shiny")
    val backShiny: String,
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_shiny")
    val frontShiny: String
)

data class Gold(
    @field:Json(name = "back_default")
    val backDefault: String,
    @field:Json(name = "back_shiny")
    val backShiny: String,
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_shiny")
    val frontShiny: String
)

data class Silver(
    @field:Json(name = "back_default")
    val backDefault: String,
    @field:Json(name = "back_shiny")
    val backShiny: String,
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_shiny")
    val frontShiny: String
)

data class Emerald(
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_shiny")
    val frontShiny: String
)

data class FireRedLeafGreen(
    @field:Json(name = "back_default")
    val backDefault: String,
    @field:Json(name = "back_shiny")
    val backShiny: String,
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_shiny")
    val frontShiny: String
)

data class RubySapphire(
    @field:Json(name = "back_default")
    val backDefault: String,
    @field:Json(name = "back_shiny")
    val backShiny: String,
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_shiny")
    val frontShiny: String
)

data class HeartGoldSoulSilver(
    @field:Json(name = "back_default")
    val backDefault: String,
    @field:Json(name = "back_female")
    val backFemale: Any,
    @field:Json(name = "back_shiny")
    val backShiny: String,
    @field:Json(name = "back_shiny_female")
    val backShinyFemale: Any,
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_female")
    val frontFemale: Any,
    @field:Json(name = "front_shiny")
    val frontShiny: String,
    @field:Json(name = "front_shiny_female")
    val frontShinyFemale: Any
)

data class Platinum(
    @field:Json(name = "back_default")
    val backDefault: String,
    @field:Json(name = "back_female")
    val backFemale: Any,
    @field:Json(name = "back_shiny")
    val backShiny: String,
    @field:Json(name = "back_shiny_female")
    val backShinyFemale: Any,
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_female")
    val frontFemale: Any,
    @field:Json(name = "front_shiny")
    val frontShiny: String,
    @field:Json(name = "front_shiny_female")
    val frontShinyFemale: Any
)

data class OmegaRubyAlphaSapphire(
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_female")
    val frontFemale: Any,
    @field:Json(name = "front_shiny")
    val frontShiny: String,
    @field:Json(name = "front_shiny_female")
    val frontShinyFemale: Any
)

data class Animated(
    @field:Json(name = "back_default")
    val backDefault: String,
    @field:Json(name = "back_female")
    val backFemale: Any,
    @field:Json(name = "back_shiny")
    val backShiny: String,
    @field:Json(name = "back_shiny_female")
    val backShinyFemale: Any,
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_female")
    val frontFemale: Any,
    @field:Json(name = "front_shiny")
    val frontShiny: String,
    @field:Json(name = "front_shiny_female")
    val frontShinyFemale: Any
)

data class XY(
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_female")
    val frontFemale: Any,
    @field:Json(name = "front_shiny")
    val frontShiny: String,
    @field:Json(name = "front_shiny_female")
    val frontShinyFemale: Any
)

data class Icons(
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_female")
    val frontFemale: Any
)

data class IconsX(
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_female")
    val frontFemale: Any
)

data class UltraSunUltraMoon(
    @field:Json(name = "front_default")
    val frontDefault: String,
    @field:Json(name = "front_female")
    val frontFemale: Any,
    @field:Json(name = "front_shiny")
    val frontShiny: String,
    @field:Json(name = "front_shiny_female")
    val frontShinyFemale: Any
)