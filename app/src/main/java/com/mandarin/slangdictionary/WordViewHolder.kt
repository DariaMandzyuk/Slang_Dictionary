package com.mandarin.slangdictionary

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mandarin.slangdictionary.model.WordModel

class WordViewHolder( // ДЕРЖАТЕЛЬ ВИЗУАЛЬНОГО ПРЕДСТАВЛЕНИЯ ЯЧЕЙКИ
    view: View,
    private val wordListener: WordListener
): RecyclerView.ViewHolder(view) {

    fun bind(model: WordModel) { // создала функцию, передала туда нашу модель
        itemView.findViewById<TextView>(R.id.title).apply {
            text = model.title
            setOnClickListener {
                wordListener.onItemClicked(model.id.toString())
            }
        }




    }
    // .text = model.title: После того как элемент найден, устанавливается его текстовое
    // содержимое (text) равным значению, которое хранится в свойстве title объекта
    // model. Таким образом, данные из model.title отображаются в найденном элементе.

    // во многих примерах бывают ViewHolder в классе Adapter, так лучше не делать
    // и лучше выносить в отдельную папку, которую можно использовать в нескольких классах
}
