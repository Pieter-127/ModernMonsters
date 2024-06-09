package com.pieterv.network.retrofit

import com.pieterv.network.model.PokemonDto
import com.pieterv.network.model.PokemonListDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {

    @GET("pokemon")
    suspend fun getPokemonList(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): PokemonListDto

    @GET("pokemon/{name}")
    suspend fun getPokemonInfo(
        @Path("name") pokemonName: String
    ): PokemonDto
}