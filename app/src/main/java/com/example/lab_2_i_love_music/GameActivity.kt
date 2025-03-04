package com.example.lab_2_i_love_music

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class GameActivity : AppCompatActivity() {
    private lateinit var scoreText: TextView
    private lateinit var bandNameText: TextView
    private lateinit var button1: Button
    private lateinit var button2: Button
    private lateinit var button3: Button
    private lateinit var backButton: Button

    private var score = 0
    private val bands = mapOf(
        "Orchid" to listOf("Destination: Blood!", "Aesthetic Dialectic", "New Ideas in Mathematics"),
        "Saetia" to listOf("Venus and Bacchus", "Notres Langues Nous Trompent", "The Sweetness and the Light"),
        "Jeromes Dream" to listOf("Exit 29 Collapsed As I Drove By", "His Life Is My Denim Paradise All Day", "True Thinkers Will Stop Time"),
        "Pg. 99" to listOf("In Love with an Apparition", "Your Face Is a Rape Scene", "The Lonesome Waltz of Leonard Cohen")
    )
    private var correctBand = ""
    private var correctTrack = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        scoreText = findViewById(R.id.scoreText)
        bandNameText = findViewById(R.id.bandNameText)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        backButton = findViewById(R.id.backButton)

        backButton.setOnClickListener { finish() }

        generateNewQuestion()

        button1.setOnClickListener { checkAnswer(button1.text.toString()) }
        button2.setOnClickListener { checkAnswer(button2.text.toString()) }
        button3.setOnClickListener { checkAnswer(button3.text.toString()) }
    }

    private fun generateNewQuestion() {
        val bandEntry = bands.entries.random()
        correctBand = bandEntry.key
        correctTrack = bandEntry.value.random()
        bandNameText.text = correctBand

        val allTracks = bands.values.flatten().shuffled()
        val options = mutableListOf(correctTrack)
        while (options.size < 3) {
            val randomTrack = allTracks.random()
            if (!options.contains(randomTrack)) options.add(randomTrack)
        }
        options.shuffle()

        button1.text = options[0]
        button2.text = options[1]
        button3.text = options[2]
    }

    private fun checkAnswer(selectedTrack: String) {
        if (selectedTrack == correctTrack) {
            score++
            scoreText.text = "Очки: $score"
            Toast.makeText(this, "Правильно!", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Неправильно!", Toast.LENGTH_SHORT).show()
        }
        generateNewQuestion()
    }
}