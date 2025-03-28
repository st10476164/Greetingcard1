package com.example.greetingcard

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class GreetingCardActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_greeting_card)

        val nameEditText = findViewById<EditText>(R.id.nameEditText)
        val messageSpinner = findViewById<Spinner>(R.id.messageSpinner)
        val previewTextView = findViewById<TextView>(R.id.previewTextView)
        val previewButton = findViewById<Button>(R.id.previewButton)
        val clearButton = findViewById<Button>(R.id.clearButton)
        val backgroundImageView = findViewById<ImageView>(R.id.backgroundImageView)

        val messages = arrayOf("Happy Birthday!", "Merry Christmas!", "Congratulations!", "Best Wishes!")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, messages)
        messageSpinner.adapter = adapter

        previewButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val message = messageSpinner.selectedItem.toString()
            if (name.isNotEmpty()) {
                previewTextView.text = "$message\n$name"
                previewTextView.visibility = View.VISIBLE
            } else {
                Toast.makeText(this, "Please enter your name", Toast.LENGTH_SHORT).show()
            }
        }

        clearButton.setOnClickListener {
            nameEditText.text.clear()
            previewTextView.text = ""
            previewTextView.visibility = View.GONE
        }
    }
}
