package com.mandarin.slangdictionary.presentation

import com.mandarin.slangdictionary.model.WordModel
import com.mandarin.slangdictionary.repository.WordRepository
import kotlinx.coroutines.runBlocking

class MainPresenter(private val wordRepository: WordRepository) { // отвечает за создание данных и получение данных откуда либо

    fun getItems(type: String): List<WordModel> {
        val items: List<WordModel> = runBlocking {
            wordRepository.getAll(type)
        }
        return items
    }

}
