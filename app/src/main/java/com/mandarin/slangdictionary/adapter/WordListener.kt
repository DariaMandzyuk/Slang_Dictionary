package com.mandarin.slangdictionary.adapter

import com.mandarin.slangdictionary.repository.WordRepository

interface WordListener {

    abstract val wordRepository: WordRepository

   suspend fun onItemClicked(id: Long)
}
