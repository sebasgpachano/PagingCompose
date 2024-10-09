package com.example.pagingcompose.data

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.pagingcompose.presentation.characters.model.CharacterModel
import com.example.pagingcompose.presentation.details.model.DetailsModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RickRepository @Inject constructor(val apiService: ApiService) {

    companion object {
        const val MAX_ITEMS = 10
        const val PREFETCH_ITEMS = 3
    }

    fun getAllCharacters(): Flow<PagingData<CharacterModel>> {
        return Pager(config = PagingConfig(pageSize = MAX_ITEMS, prefetchDistance = PREFETCH_ITEMS),
            pagingSourceFactory = {
                CharacterPagingSource(apiService)
            }).flow
    }

    suspend fun getCharacter(id: Int): DetailsModel {
        return apiService.getCharacter(id).toDetails()
    }
}