package com.example.pagingcompose.presentation.details

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pagingcompose.data.RickRepository
import com.example.pagingcompose.presentation.details.model.DetailsModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val rickRepository: RickRepository) :
    ViewModel() {

    private val detailsMutableStateFlow = MutableStateFlow<DetailsModel?>(null)
    val detailsStateFlow: StateFlow<DetailsModel?> get() = detailsMutableStateFlow

    fun fetchCharacter(id: Int) {
        viewModelScope.launch {
            try {
                val details = rickRepository.getCharacter(id)
                detailsMutableStateFlow.value = details
            } catch (e: Exception) {
                Log.e("DetailsViewModel", "Error character details", e)
            }
        }
    }

}