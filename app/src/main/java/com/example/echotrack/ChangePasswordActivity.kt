package com.example.echotrack

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChangePasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.change_password)

        val etCurrentPassword = findViewById<EditText>(R.id.etCurrentPassword)
        val etNewPassword = findViewById<EditText>(R.id.etNewPassword)
        val etConfirmNewPassword = findViewById<EditText>(R.id.etConfirmNewPassword)
        val btnSavePassword = findViewById<Button>(R.id.btnSavePassword)
        val btnCancelChange = findViewById<Button>(R.id.btnCancelChange)

        btnSavePassword.setOnClickListener {
            val current = etCurrentPassword.text.toString()
            val newPw = etNewPassword.text.toString()
            val confirmPw = etConfirmNewPassword.text.toString()

            if (current.isEmpty() || newPw.isEmpty() || confirmPw.isEmpty()) {
                Toast.makeText(this, "Please fill all fields.", Toast.LENGTH_SHORT).show()
            } else if (newPw != confirmPw) {
                Toast.makeText(this, "New passwords do not match.", Toast.LENGTH_SHORT).show()
            } else {
                // Fake validation: always succeeds for the demo
                Toast.makeText(this, "Password changed successfully!", Toast.LENGTH_SHORT).show()
                finish() // Go back to previous screen
            }
        }

        btnCancelChange.setOnClickListener {
            finish()
        }
    }
}
