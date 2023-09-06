package com.mandarin.slangdictionary.presentation

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.mandarin.slangdictionary.WordViewModel
import com.mandarin.slangdictionary.R
import com.mandarin.slangdictionary.dto.Word

class WordFragment : Fragment(R.layout.word_presenter) {

    private val viewModel: WordViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun onLike(word: Word) {
            viewModel.addFavourite(word.id)
        }
    }
}
