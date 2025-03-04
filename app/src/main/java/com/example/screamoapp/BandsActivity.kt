package com.example.screamoapp

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class BandsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bands)

        val listView: ListView = findViewById(R.id.listView)
        val bands = resources.getStringArray(R.array.bands)

        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, bands)
        listView.adapter = adapter

        listView.setOnItemClickListener { _, view, _, _ ->
            val bandName = (view as TextView).text
            Toast.makeText(this, "🔥 $bandName 🔥", Toast.LENGTH_SHORT).show()
        }
    }
}