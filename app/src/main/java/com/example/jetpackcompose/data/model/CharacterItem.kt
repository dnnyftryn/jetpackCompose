package com.example.jetpackcompose.data.model

import com.squareup.moshi.JsonClass
import com.squareup.moshi.Json

@JsonClass(generateAdapter = true)
data class CharacterItem(
	@Json(name = "actor")
	val actor: String,

	@Json(name = "name")
	val name: String,

	@Json(name = "image")
	val image: String
)