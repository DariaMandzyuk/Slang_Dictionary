package com.mandarin.slangdictionary.api

import okhttp3.OkHttpClient
import javax.inject.Inject
import java.lang.RuntimeException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Call


private const val BASE_URL = "http://10.0.2.2:9999/api/word-model/"

class ApiSlangDictionary @Inject constructor(
    private val client: OkHttpClient,
) {

    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val service: WordService = retrofit.create(WordService::class.java)

    fun getListData(type: String): List<Map<String, Any>> {
        try {
            val call = service.getListData(type)
            val response = call.execute()
            if (response.isSuccessful) {
                val jsonResponse = response.body()
                return jsonResponse ?: emptyList()
            } else {
                throw RuntimeException()
            }
        } catch (e: Exception) {
            throw RuntimeException()
        }
    }
}

