package com.mandarin.slangdictionary

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView

class FragmentZoomersList : Fragment(R.layout.fragment_zoomers_list), WordListener {

    private val adapter by lazy { WordAdapter(this) }
    private val presenter by lazy { MainPresenter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerViewZoomersList)
        recyclerView.adapter = adapter // 1. сконнектили адаптер с ресайклером
        adapter.setItems(presenter.getItems()) // 2. передаем в адаптер айтемы
    }

    override fun onItemClicked(text: String) {

    }
}
// самая распространенная ошибка при реализации ресаклера это то что не указывается LayoutManager
// если про него забыть, то список не будет отображаться и в логах будет "No layout manager attached"
//
//

