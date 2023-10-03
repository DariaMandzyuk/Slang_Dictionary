package com.mandarin.slangdictionary.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface WordService {

    @GET("type/{type}")
    fun getListData(@Path("type") type: String): Call<List<Map<String, Any>>>
}

