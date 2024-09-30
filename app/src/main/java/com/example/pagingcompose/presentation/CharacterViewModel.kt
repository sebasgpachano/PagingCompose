package com.example.pagingcompose.presentation

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.example.pagingcompose.data.RickRepository
import com.example.pagingcompose.presentation.model.CharacterModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(rickRepository: RickRepository) : ViewModel() {

    val characters: Flow<PagingData<CharacterModel>> = rickRepository.getAllCharacters()
}