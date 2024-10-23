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


class MainActivity : AppCompatActivity() {
    private lateinit var editText: EditText
    private lateinit var repliedMessageView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.root_layout_main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // Initialize the views
        editText = findViewById(R.id.editTextMain)
        repliedMessageView = findViewById(R.id.repliedMessage)
        val sendButton: Button = findViewById(R.id.main_send_button)

        // Handle button click to send message to SecondActivity
        sendButton.setOnClickListener {
            val message = editText.text.toString()

            // Create an intent with URI
            val messageUri = Uri.parse("message:$message")
            val intent = Intent(this, SecondActivity::class.java).apply {
                data = messageUri // Pass URI as intent data
            }
            startActivity(intent)
        }
    }
    // Receive reply from SecondActivity using intent extras
    override fun onResume() {
        super.onResume()
        intent?.let {
            if (it.hasExtra("reply")) {
                val reply = it.getStringExtra("reply")
                repliedMessageView.text = "Reply: $reply" // Display the reply
            }
        }
    }
}