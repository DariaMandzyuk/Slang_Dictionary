package com.mandarin.slangdictionary.repository

import com.mandarin.slangdictionary.api.ApiSlangDictionary
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.SocketTimeoutException
import javax.inject.Inject
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.mandarin.slangdictionary.model.WordModel

class WordRepositoryInMemoryImpl @Inject constructor(
    private val apiSlangDictionary: ApiSlangDictionary
) : WordRepository {

    private var data: List<WordModel> = mutableListOf() // это список объектов типа WordModel, который будет содержать данные после их получения из сети.
    private val gson = Gson() // это экземпляр Gson, который используется для преобразования JSON-строк в объекты и наоборот
    override suspend fun getAll(type: String): List<WordModel> {
        return withContext(Dispatchers.IO) {
            try {
                val responseJson = apiSlangDictionary.getListData(type)
                val tempList: List<WordModel> = gson.fromJson(
                    responseJson.toString(),
                    object : TypeToken<List<WordModel>>() {}.type
                )
                tempList // Return the parsed list
            } catch (e: SocketTimeoutException) {
                throw Exception("Socket timeout")
            }
        }
    }

    override fun getWord(wordId: String): WordModel? {
        return data.find { it.id.toString() == wordId }
    }

    override fun likeById(id: Long) {

    }
}

