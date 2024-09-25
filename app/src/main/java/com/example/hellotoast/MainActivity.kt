package com.example.hellotoast

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Initialize the counter variable
    private var diceResult = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the Button and TextView elements from the layout
        val toastButton = findViewById<Button>(R.id.button_toast)
        val diceTextView = findViewById<TextView>(R.id.textview_dice_result)
//        val countButton = findViewById<Button>(R.id.button_roll_dice)
//        val countTextView = findViewById<TextView>(R.id.textview_count)

        // Set an initial value for the dice result
        diceTextView.text = diceResult.toString()

        // Set a click listener for the Toast button
        toastButton.setOnClickListener {
            // Display a short Toast message
            Toast.makeText(this, "Hello Toast!", Toast.LENGTH_SHORT).show()
            // set initial value for the dice result
            diceTextView.text = diceResult.toString()
        }


//        // Set a click listener for the Count button
//        countButton.setOnClickListener {
//            // Increase the count and update the TextView
//            count++
//            countTextView.text = count.toString()
        //}
// Method to roll the dice
fun rollingDice(view: android.view.View) {
    // Generate a random number between 1 and 6
    diceResult = Random.nextInt(1, 7)

    // Find the TextView and update it with the dice roll result
    val diceTextView = findViewById<TextView>(R.id.textview_dice_result)
    diceTextView.text = diceResult.toString()

    // Optionally, display a toast message
    Toast.makeText(this, "You rolled a $diceResult!", Toast.LENGTH_SHORT).show()
}
    }
}

