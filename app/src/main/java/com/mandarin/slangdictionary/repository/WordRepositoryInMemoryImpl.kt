package com.mandarin.slangdictionary.repository

import androidx.lifecycle.MutableLiveData
import com.mandarin.slangdictionary.model.WordModel
import javax.inject.Inject

class WordRepositoryInMemoryImpl @Inject constructor() : WordRepository {
    private var model = listOf(
        WordModel(
            id = 1,
            title = "Кринж",
            likedByMe = false
        ),
        WordModel(
            id = 2,
            title = "Имба",
            likedByMe = false
        ),
        WordModel(
            id = 3,
            title = "Рофлить",
            likedByMe = false
        ),
        WordModel(
            id = 4,
            title = "Краш",
            likedByMe = false
        ),
        WordModel(
            id = 5,
            title = "Флексить",
            likedByMe = false
        ),
        WordModel(
            id = 6,
            title = "Ауф",
            likedByMe = false
        ),
        WordModel(
            id = 7,
            title = "Форсить",
            likedByMe = false
        ),
        WordModel(
            id = 8,
            title = "Дед инсайд",
            likedByMe = false
        ),
        WordModel(
            id = 9,
            title = "Агриться",
            likedByMe = false
        ),
        WordModel(
            id = 10,
            title = "Буллинг",
            likedByMe = false
        ),
        WordModel(
            id = 11,
            title = "Скам",
            likedByMe = false
        ),
        WordModel(
            id = 12,
            title = "Шипперить",
            likedByMe = false
        ),
        WordModel(
            id = 13,
            title = "POV, или ПОВ",
            likedByMe = false
        ),
        WordModel(
            id = 14,
            title = "Рофл",
            likedByMe = false
        ),
        WordModel(
            id = 15,
            title = "Сабж",
            likedByMe = false
        ),
        WordModel(
            id = 16,
            title = "Свэг",
            likedByMe = false
        ),
        WordModel(
            id = 17,
            title = "Симп",
            likedByMe = false
        ),
        WordModel(
            id = 18,
            title = "Стэнить",
            likedByMe = false
        ),
        WordModel(
            id = 19,
            title = "Тильт",
            likedByMe = false
        ),
        WordModel(
            id = 20,
            title = "Треш",
            likedByMe = false
        ),
        WordModel(
            id = 21,
            title = "Хайп",
            likedByMe = false
        )
    )


    private val data =
        MutableLiveData(model)

    override fun getAll(): List<WordModel> = model

    override fun likeById(id: Long) {
        model = model.map {
            if (it.id != id) {
                it
            } else {
                it.copy(likedByMe = !it.likedByMe)
            }
        }
        data.value = model
        }
    }

