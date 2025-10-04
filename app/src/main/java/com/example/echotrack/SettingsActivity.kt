package com.example.echotrack

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SettingsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings)

        // Edit Profile
        val btnEditProfile = findViewById<Button>(R.id.btnEditProfile)
        btnEditProfile.setOnClickListener {
            // Navigate to EditProfileActivity
            val intent = Intent(this, EditProfileActivity::class.java)
            startActivity(intent)
        }

        // Notifications Toggle
        val switchNotifications = findViewById<Switch>(R.id.switchNotifications)
        switchNotifications.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                Toast.makeText(this, "Notifications Enabled", Toast.LENGTH_SHORT).show()
                // Enable notifications logic here
            } else {
                Toast.makeText(this, "Notifications Disabled", Toast.LENGTH_SHORT).show()
                // Disable notifications logic here
            }
        }

        // Change Password
        val btnChangePassword = findViewById<Button>(R.id.btnChangePassword)
        btnChangePassword.setOnClickListener {
            // For demo: Show toast, or you can navigate to a ChangePasswordActivity
            Toast.makeText(this, "Change Password Clicked", Toast.LENGTH_SHORT).show()
        }

        // Logout
        val btnLogout = findViewById<Button>(R.id.btnLogout)
        btnLogout.setOnClickListener {
            // Logout logic here
            Toast.makeText(this, "Logged out!", Toast.LENGTH_SHORT).show()
            // You can navigate to LoginActivity if you want
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        findViewById<View>(R.id.btnChangePassword).setOnClickListener {
            val intent = Intent(this, ChangePasswordActivity::class.java)
            startActivity(intent)


        }

    }
}
