package com.mandarin.slangdictionary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandarin.slangdictionary.repository.WordRepositoryInMemoryImpl

class WordViewModel : ViewModel() {
    // создаем публичный стейт вью модели, на котором будет описываться вьюшка
    private val _state = MutableLiveData<MainViewState>()
    val viewState: LiveData<MainViewState> = _state

    val wordRepository = WordRepositoryInMemoryImpl()

    fun addFavourite(id: Long) = wordRepository.likeById(id)

}
