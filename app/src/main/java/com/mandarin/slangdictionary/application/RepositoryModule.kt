package com.mandarin.slangdictionary.application

import com.mandarin.slangdictionary.repository.WordRepository
import com.mandarin.slangdictionary.repository.WordRepositoryInMemoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule { // Этот модуль предоставляет репозиторий как синглтон.

    @Singleton
    @Provides
    fun provideWordRepository(): WordRepository {
        return WordRepositoryInMemoryImpl()
    }
}
