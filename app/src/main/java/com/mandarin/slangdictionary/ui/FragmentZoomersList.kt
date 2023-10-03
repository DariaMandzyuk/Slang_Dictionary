package com.mandarin.slangdictionary.ui

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.mandarin.slangdictionary.adapter.WordAdapter
import com.mandarin.slangdictionary.adapter.WordListener
import com.mandarin.slangdictionary.repository.WordRepository
import com.mandarin.slangdictionary.presentation.MainPresenter
import androidx.navigation.fragment.findNavController
import com.mandarin.slangdictionary.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentZoomersList (override val wordRepository: WordRepository) : Fragment(R.layout.fragment_zoomers_list),
    WordListener {

    private val adapter by lazy { WordAdapter(this) }
    private val presenter by lazy { MainPresenter(wordRepository) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewZoomersList)
        recyclerView.adapter = adapter // 1. сконнектили адаптер с ресайклером
        adapter.setItems(presenter.getItems("ZOOMERS")) // 2. передаем в адаптер айтемы
    }

    override suspend fun onItemClicked(id: Long) {
        val bundle = bundleOf("wordId" to id.toString()) //
        findNavController().navigate(R.id.action_fragmentZoomersList_to_wordFragment2,  bundle)
    }
}
// самая распространенная ошибка при реализации ресайклера это то что не указывается LayoutManager
// если про него забыть, то список не будет отображаться и в логах будет "No layout manager attached"


