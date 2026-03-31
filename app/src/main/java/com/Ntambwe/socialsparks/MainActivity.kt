package com.Ntambwe.socialsparks

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Tag for logging
    private val TAG = "SocialSparks"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get references to UI elements
        val etTimeOfDay = findViewById<EditText>(R.id.etTimeOfDay)
        val btnGetSpark = findViewById<Button>(R.id.btnGetSpark)
        val tvSuggestion = findViewById<TextView>(R.id.tvSuggestion)
        val btnReset = findViewById<Button>(R.id.btnReset)

        Log.d(TAG, "App started successfully")

        // Button to get suggestion
        btnGetSpark.setOnClickListener {
            val timeInput = etTimeOfDay.text.toString().trim().lowercase()
            Log.d(TAG, "User entered: $timeInput")

            val suggestion = when {
                timeInput.contains("morning") -> "☀️ Send a 'Good morning' text to a family member!"
                timeInput.contains("mid-morning") || timeInput.contains("mid morning") -> "💼 Reach out to a colleague with a quick 'Thank you'!"
                timeInput.contains("afternoon") -> "😂 Share a funny meme or interesting link with a friend!"
                timeInput.contains("snack") -> "💭 Send a quick 'thinking of you' message!"
                timeInput.contains("dinner") -> "📞 Call a friend or relative for a 5-minute catch-up!"
                timeInput.contains("night") || timeInput.contains("evening") -> "💬 Leave a thoughtful comment on a friend's post!"
                else -> "❌ Please enter a valid time like: Morning, Afternoon, Dinner, Night"
            }

            tvSuggestion.text = suggestion
            Log.d(TAG, "Suggestion shown: $suggestion")
        }

        // Reset button
        btnReset.setOnClickListener {
            etTimeOfDay.text.clear()
            tvSuggestion.text = ""
            Log.d(TAG, "App reset by user")
        }
    }
}