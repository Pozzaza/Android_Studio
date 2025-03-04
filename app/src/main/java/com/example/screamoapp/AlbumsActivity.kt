package com.example.screamoapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AlbumsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_albums)

        val albums = arrayOf(
            "Orchid - Chaos Is Me",
            "Pg. 99 - Document #8",
            "Saetia - Saetia",
            "Loma Prieta - I.V.",
            "Jeromes Dream - Seeing Means More Than Safety"
        )

        val listView: ListView = findViewById(R.id.listView)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, albums)
        listView.adapter = adapter
    }
}