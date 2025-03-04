package com.example.screamoapp

import android.app.TabActivity
import android.content.Intent
import android.os.Bundle
import android.widget.TabHost

@Suppress("DEPRECATION")
class MainActivity : TabActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabHost: TabHost = findViewById(android.R.id.tabhost)

        tabHost.addTab(tabHost.newTabSpec("Genre")
            .setIndicator("Жанр")
            .setContent(Intent(this, GenreActivity::class.java)))

        tabHost.addTab(tabHost.newTabSpec("Bands")
            .setIndicator("Гурти")
            .setContent(Intent(this, BandsActivity::class.java)))

        tabHost.addTab(tabHost.newTabSpec("Albums")
            .setIndicator("Альбоми")
            .setContent(Intent(this, AlbumsActivity::class.java)))
    }
}