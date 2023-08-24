package com.mandarin.slangdictionary

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mandarin.slangdictionary.model.WordModel

class WordAdapter(
    private val wordListener: WordListener // в конструктор адаптера передает листенер, который реализует клики по кнопке
): RecyclerView.Adapter<WordViewHolder>() { // 1. создала класс, наследованный от адаптера

    private var items = emptyList<WordModel>() // 2. указала список itemов, которые буду запихивать туда

    fun setItems(newItems: List<WordModel>) {
        items = newItems
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int { // 3. переопределила метод getItemCount, который возвращает количество элементов в списке
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder { // 4. Переопределила создание вьюхолдера, в данном случае тип 1
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_word, parent, false) // ЭТОТ МЕТОД СОЗДАЕТ НАМ ВЬЮХОЛДЕРЫ
        val viewHolder = WordViewHolder(view, wordListener)
        return viewHolder
    }

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) { // 5. Переопределила метод который отвечает за вставление данных во вьюхолдер
        holder.bind(items[position])
    }
}
