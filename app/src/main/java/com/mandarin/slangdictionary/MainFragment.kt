package com.mandarin.slangdictionary

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment
import com.mandarin.slangdictionary.repository.WordRepository
import com.mandarin.slangdictionary.repository.WordRepositoryInMemoryImpl
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment(R.layout.fragment_main) {

    @Inject
    lateinit var wordRepository: WordRepository

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<Button>(R.id.to_fragment_zoomers_list).setOnClickListener {
            parentFragmentManager.beginTransaction().replace(R.id.container, FragmentZoomersList(wordRepository))
                .commit()
        }
    }
}


