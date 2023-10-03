package com.mandarin.slangdictionary.repository

import com.mandarin.slangdictionary.model.WordModel
import kotlinx.coroutines.flow.Flow

interface WordRepository {
    suspend fun getAll(type: String) : List<WordModel>

    fun getWord(wordId: String) : WordModel?

    fun likeById(id: Long)

}
