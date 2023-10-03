//package com.mandarin.slangdictionary.network
//
//import android.app.Application
//import com.mandarin.slangdictionary.WordService
//import okhttp3.OkHttpClient
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//
//private const val BASE_URL = "http://localhost:9999/api/word-model" // будем использовать в http клиенте когда будем ходить на сервер
//
//class App: Application() { // потом надо будет прокинуть это через DI
//
//    lateinit var services: WordService //
//
//    override fun onCreate() {
//        super.onCreate()
//
//        instance = this // инициализируем инстанс
//        initRetrofit()
//    }
//
//    private fun initRetrofit() {
//
//        val client = OkHttpClient.Builder() // клиент, через которого будут слаться запросы
//            .build()
//
//        // РЕТРОФИТ СОЕДИНЯЕТ НАШ КЛИЕНТ(client) С НАШИМИ ИНТ ПОИНТАМИ(WordService)
//        val retrofitServices = Retrofit.Builder()
//            .baseUrl(BASE_URL)
//            .addConverterFactory(GsonConverterFactory.create()) // добавляем фабрику чтобы знать как работать с клиентом
//            .client(client) // клиент - через что мы ходим в сеть
//            .build() // ретрофит создан
//
//        // инициализируем сервис для вызова методов
//        services = retrofitServices.create(WordService::class.java)
//        // дальше при помощи кодогенерации он создаст файлики и позволит нам сходить по инт поинту
//    }
//
//    companion object {
//        lateinit var instance: App
//    }
//}
