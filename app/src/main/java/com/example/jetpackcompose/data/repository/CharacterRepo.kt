package com.example.jetpackcompose.data.repository

import com.example.jetpackcompose.data.RequestAPI
import com.example.jetpackcompose.data.model.CharacterItem
import javax.inject.Inject

class CharacterRepo @Inject constructor(
    private val requestAPI: RequestAPI
) {
    suspend fun getCharacters() : List<CharacterItem> {
        return requestAPI.getCharacter()
    }
}