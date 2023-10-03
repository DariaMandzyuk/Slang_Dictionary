package com.mandarin.slangdictionary.ui

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.mandarin.slangdictionary.viewmodel.WordViewModel
import com.mandarin.slangdictionary.R
import com.mandarin.slangdictionary.dto.Word
import com.mandarin.slangdictionary.model.WordModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WordFragment : Fragment(R.layout.word_presenter) {

    private val viewModel: WordViewModel by activityViewModels()

    //аргумент для хранения wordId
    val args: WordFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val wordId = args.wordId

        // Загрузка данных о слове и отображение их на экране
        viewModel.loadWordById(wordId)

        // Наблюдение за LiveData для отображения данных на экране
        viewModel.data.observe(viewLifecycleOwner) { word ->
            // Отобразите полученные данные о слове на экране
            displayWordDetails(word)
        }
    }

    private fun displayWordDetails(word: WordModel?) {
        if (word != null) {
            val titleTextView = view?.findViewById<TextView>(R.id.title)
            val textTextView = view?.findViewById<TextView>(R.id.description)

            titleTextView?.text = word.title
            textTextView?.text = word.wordDescription
        }
    }
}
