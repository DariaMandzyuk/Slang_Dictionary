package com.mandarin.slangdictionary.model

import com.google.gson.annotations.SerializedName

data class WordModel( // это представление в списке. Модель данных, которая используется как модель JSON
    @SerializedName("id")
    val id: Long,
    @SerializedName("title")
    val title: String,
    @SerializedName("wordDescription")
    val wordDescription: String,
    @SerializedName("likedByMe")
    val likedByMe: Boolean = false,
    @SerializedName("image")
    val image: String
)
