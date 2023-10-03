package com.mandarin.slangdictionary.ui

import com.mandarin.slangdictionary.dto.Word

sealed class MainViewState

data class FavouriteWords(
    val word: Word
) : MainViewState()
