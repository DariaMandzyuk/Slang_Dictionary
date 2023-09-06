package com.mandarin.slangdictionary.dto

data class Word( // это полное представление
    val id: Long,
    val content: String,
    val likedByMe: Boolean = false
)
