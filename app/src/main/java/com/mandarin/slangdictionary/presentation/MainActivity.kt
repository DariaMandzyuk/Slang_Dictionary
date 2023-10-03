package com.mandarin.slangdictionary.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mandarin.slangdictionary.ui.MainFragment
import com.mandarin.slangdictionary.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()
    }
}
