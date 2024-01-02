package com.example.jetpackcompose.data

import com.example.jetpackcompose.data.model.CharacterItem
import retrofit2.http.GET

interface RequestAPI {
    @GET("characters")
    suspend fun getCharacter() : List<CharacterItem>
}