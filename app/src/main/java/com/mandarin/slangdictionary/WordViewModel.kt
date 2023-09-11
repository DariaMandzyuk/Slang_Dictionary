package com.mandarin.slangdictionary

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.mandarin.slangdictionary.repository.WordRepository
import com.mandarin.slangdictionary.repository.WordRepositoryInMemoryImpl
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class WordViewModel @Inject constructor(
    private val wordRepository : WordRepository
): ViewModel() {
    // создаем публичный стейт вью модели, на котором будет описываться вьюшка
    private val _state = MutableLiveData<MainViewState>()
    val viewState: LiveData<MainViewState> = _state

//    val wordRepository = WordRepositoryInMemoryImpl()

    fun addFavourite(id: Long) = wordRepository.likeById(id)

}
