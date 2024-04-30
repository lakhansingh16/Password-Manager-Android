package com.example.passwordgenerator

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity
import com.example.passwordgenerator.models.LowerCaseGenerator
import com.example.passwordgenerator.models.NumericGenerator
import com.example.passwordgenerator.models.PasswordGenerator
import com.example.passwordgenerator.models.SpecialCharGenerator
import com.example.passwordgenerator.models.UpperCaseGenerator

class MainActivity : ComponentActivity() {
    private lateinit var editPasswordSize: EditText
    private lateinit var textPasswordGenerated: TextView
    private lateinit var textErrorMessage: TextView
    private lateinit var checkLower: CheckBox
    private lateinit var checkUpper: CheckBox
    private lateinit var checkSpecialChar: CheckBox
    private lateinit var checkNumeric: CheckBox
    private lateinit var btnGenerate: Button
    private lateinit var btnCopy: Button
    private lateinit var btnRating:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        clickListeners()
    }

    private fun clickListeners() {
        btnGenerate.setOnClickListener {
            val passwordSize = editPasswordSize.text.toString().toIntOrNull() ?: return@setOnClickListener
            textErrorMessage.text = ""

            if (passwordSize < 8) {
                textErrorMessage.text = "Password Size must be greater than 8"
                return@setOnClickListener
            }

            PasswordGenerator.clear()
            if (checkLower.isChecked) PasswordGenerator.add(LowerCaseGenerator())
            if (checkNumeric.isChecked) PasswordGenerator.add(NumericGenerator())
            if (checkUpper.isChecked) PasswordGenerator.add(UpperCaseGenerator())
            if (checkSpecialChar.isChecked) PasswordGenerator.add(SpecialCharGenerator())

            if (PasswordGenerator.isEmpty()) {
                textErrorMessage.text = "Please select at least one password content type"
                return@setOnClickListener
            }

            val passwrd = PasswordGenerator.generatePassword(passwordSize)
            textPasswordGenerated.text = passwrd
        }

        btnCopy.setOnClickListener {
            val manager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            manager.setPrimaryClip(ClipData.newPlainText("password", textPasswordGenerated.text))
            Toast.makeText(this@MainActivity, "Password Copied", Toast.LENGTH_SHORT).show()
        }
        btnRating.setOnClickListener {
            val intent = Intent(this, RatingPage::class.java)
            startActivity(intent)
        }
    }

    private fun initViews() {
        editPasswordSize = findViewById(R.id.edit_pwd_size)
        textPasswordGenerated = findViewById(R.id.text_password_result)
        textErrorMessage = findViewById(R.id.text_error)
        checkLower = findViewById(R.id.check_lower)
        checkUpper = findViewById(R.id.check_upper)
        checkSpecialChar = findViewById(R.id.check_special_char)
        checkNumeric = findViewById(R.id.check_numeric)
        btnGenerate = findViewById(R.id.btn_generate)
        btnCopy = findViewById(R.id.btn_copy)
        btnRating = findViewById(R.id.btn_rating)
    }
}
