package com.example.passwordgenerator

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import androidx.activity.ComponentActivity
import androidx.activity.result.contract.ActivityResultContracts

class RatingPage : ComponentActivity() {
    private val sendEmail = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.rating)
        val submitBtn: Button = findViewById(R.id.btn_submit)
        val feedback:EditText = findViewById(R.id.feedback)
        val ratingBar: RatingBar = findViewById(R.id.ratingBar)
        submitBtn.setOnClickListener {
            val rating = ratingBar.rating
            val feedbackText = feedback.text.toString()
            val emailIntent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL, arrayOf("lakhanbarod165@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT, "App Feedback")
                putExtra(Intent.EXTRA_TEXT, "Rating: $rating\nFeedback: $feedbackText")
            }
            sendEmail.launch(Intent.createChooser(emailIntent, "Send Feedback"))
        }
    }
}