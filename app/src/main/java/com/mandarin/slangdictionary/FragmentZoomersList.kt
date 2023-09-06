package com.mandarin.slangdictionary

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.mandarin.slangdictionary.adapter.WordAdapter
import com.mandarin.slangdictionary.adapter.WordListener
import com.mandarin.slangdictionary.repository.WordRepository
import com.mandarin.slangdictionary.presentation.MainPresenter

class FragmentZoomersList(override val wordRepository: WordRepository) : Fragment(R.layout.fragment_zoomers_list),
    WordListener {

    private val adapter by lazy { WordAdapter(this) }
    private val presenter by lazy { MainPresenter(wordRepository) }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewZoomersList)
        recyclerView.adapter = adapter // 1. сконнектили адаптер с ресайклером
        adapter.setItems(presenter.getItems()) // 2. передаем в адаптер айтемы
    }

    // тут буду открывать фрагмент через чаилдфрагмент, потому что когда мы открываем фрагмент из другого фрагмента то открывать нужно через чаилд
    override fun onItemClicked(text: String) {
        // тут наверно лучше передавать айдишник и потом открывать фрагмент
    }
}
// самая распространенная ошибка при реализации ресаклера это то что не указывается LayoutManager
// если про него забыть, то список не будет отображаться и в логах будет "No layout manager attached"


