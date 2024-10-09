package com.example.pagingcompose.data

import com.example.pagingcompose.data.response.CharacterResponse
import com.example.pagingcompose.data.response.ResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("/api/character")
    suspend fun getCharacters(@Query("page") page: Int): ResponseWrapper

    @GET("/api/character/{id}")
    suspend fun getCharacter(@Path("id") id: Int): CharacterResponse
}