package com.pieterv.data.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.pieterv.data.repository.mapper.toPokedexEntry
import com.pieterv.data.repository.model.PokemonListEntry
import com.pieterv.database.model.PokedexListEntryEntity
import com.pieterv.database.pokemon.PokemonListDao
import com.pieterv.network.retrofit.PokemonApi
import javax.inject.Inject

class PokemonPagingSource @Inject constructor(
    private val api: PokemonApi,
    private val pokemonListDao: PokemonListDao
) : PagingSource<Int, PokemonListEntry>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PokemonListEntry> {
        return try {
            val nextPageNumber = params.key ?: 0
            val pageSize = PAGE_SIZE

            val response = fetchPokemon(nextPageNumber, pageSize)

            LoadResult.Page(
                data = response.toPokedexEntry(),
                prevKey = if (nextPageNumber == 0) null else nextPageNumber - 1,
                nextKey = if (response.isEmpty()) null else nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }

    private suspend fun fetchPokemon(
        pageNumber: Int,
        pageSize: Int
    ): List<PokedexListEntryEntity> {
        val offset = pageNumber * pageSize
        val pokemonInDb = pokemonListDao.getPokemonRange(pageSize, offset)

        return pokemonInDb.ifEmpty {
            val pokedexEntries = pokedexListEntries(pageSize, offset)
            pokemonListDao.insertAll(pokedexEntries)

            emptyList()
        }

    }

    private suspend fun pokedexListEntries(
        pageSize: Int,
        offset: Int
    ): ArrayList<PokedexListEntryEntity> {
        val responseFromApi = api.getPokemonList(pageSize, offset)
        return responseFromApi.toPokedexEntry()
    }

    override fun getRefreshKey(state: PagingState<Int, PokemonListEntry>): Int? {
        return null
    }

    companion object {
        private const val PAGE_SIZE = 20
    }
}