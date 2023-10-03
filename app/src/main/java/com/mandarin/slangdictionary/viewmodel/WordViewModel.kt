package com.mandarin.slangdictionary.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandarin.slangdictionary.model.WordModel
import com.mandarin.slangdictionary.repository.WordRepository
import com.mandarin.slangdictionary.repository.WordRepositoryInMemoryImpl
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordViewModel @Inject constructor(
    private val wordRepository : WordRepository,
    private val state: SavedStateHandle
): ViewModel() {

    // создаем публичный стейт вью модели, на котором будет описываться вьюшка
    private val _data = MutableLiveData<WordModel>()
    val data: LiveData<WordModel>
        get() = _data

    // Загрузка данных о слове по wordId
    fun loadWordById(wordId: String) {
        viewModelScope.launch {
            val word = wordRepository.getWord(wordId)
            _data.postValue(word!!)
        }
    }
    fun addFavourite(id: Long) = wordRepository.likeById(id)

}
