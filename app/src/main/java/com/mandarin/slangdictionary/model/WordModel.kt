package com.mandarin.slangdictionary.model

data class WordModel( // это представление в списке
    val title: String,
    val id: Long,
    val likedByMe: Boolean = false
)
