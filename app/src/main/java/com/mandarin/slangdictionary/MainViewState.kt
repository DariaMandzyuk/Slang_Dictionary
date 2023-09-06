package com.mandarin.slangdictionary

import com.mandarin.slangdictionary.dto.Word

sealed class MainViewState

data class FavouriteWords(
    val word: Word
) : MainViewState()
