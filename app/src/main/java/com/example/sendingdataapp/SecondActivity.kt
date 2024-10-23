package com.example.sendingdataapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.net.Uri
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var receivedMessageView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.root_layout_second)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Initialize views
        receivedMessageView = findViewById(R.id.receivedMessage)
        editText = findViewById(R.id.editTextSecond)
        val sendButton: Button = findViewById(R.id.sendButtonSecond)

        // Receive the message from MainActivity using URI data
        intent?.data?.let { data: Uri ->
            val message = data.schemeSpecificPart // Extract the message
            receivedMessageView.text = "Received: $message" // Display the received message
        }

        // Handle button click to send a reply back to MainActivity
        sendButton.setOnClickListener {
            val replyMessage = editText.text.toString()

            // Create an Intent to send the reply back to MainActivity
            val replyIntent = Intent(this, MainActivity::class.java).apply {
                putExtra("reply", replyMessage) // Send reply as intent extras
            }
            startActivity(replyIntent) // Start MainActivity with the reply data
        }
    }
}