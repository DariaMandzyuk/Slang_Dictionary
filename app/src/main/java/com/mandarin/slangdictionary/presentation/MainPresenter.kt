package com.mandarin.slangdictionary.presentation

import com.mandarin.slangdictionary.model.WordModel
import com.mandarin.slangdictionary.repository.WordRepository

class MainPresenter(private val wordRepository: WordRepository) { // отвечает за создание данных и получение данных откуда либо

    fun getItems(): List<WordModel> {
        return wordRepository.getAll()
    }

//    fun getItems() : List<WordModel> {
//        val mutableList = mutableListOf<WordModel>()
//        for (i in 1 .. 20) {
//            val model = WordModel(
//                id = i,
//                title = "Some title $i")
//            mutableList.add(model)
//        }
//        return mutableList
//    }
}
// Презентер - это сущность, которая отвечает за поставку данных
// и на практике здесь были бы какие-то запросы, походы в базу данных, в кеш
// для нас она пока просто возвращает списочек

