package com.example.pagingcompose.data

import com.example.pagingcompose.data.response.ResponseWrapper
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("/api/character")
    suspend fun getCharacters(@Query("page") page: Int): ResponseWrapper
}