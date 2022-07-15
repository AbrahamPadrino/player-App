package com.example.playerapp.models

data class AlbumModel(
    val id: Int,
    val artistId: Int,
    val name: String,
    val imageResourceId: Int,
    val createdAt: Long? =  null,
    val songsQuantity: Int? =  null
)