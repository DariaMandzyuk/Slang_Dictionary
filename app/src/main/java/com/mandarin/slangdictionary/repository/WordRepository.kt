package com.mandarin.slangdictionary.repository

import com.mandarin.slangdictionary.model.WordModel
import kotlinx.coroutines.flow.Flow

interface WordRepository {
    fun getAll() : List<WordModel> // скорее всего понадобится контейнер для лайкнутых слов, но этот пока тоже оставлю

    fun likeById(id: Long)

}
