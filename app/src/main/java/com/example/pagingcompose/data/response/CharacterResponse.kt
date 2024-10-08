package com.example.pagingcompose.data.response

import com.example.pagingcompose.presentation.characters.model.CharacterModel
import com.google.gson.annotations.SerializedName

data class CharacterResponse(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String,
    @SerializedName("status") val status: String,
    @SerializedName("species") val species: String,
    @SerializedName("gender") val gender: String,
){
    fun toPresentation(): CharacterModel {
        return CharacterModel(
            id = id,
            name = name,
            image = image
        )
    }
}