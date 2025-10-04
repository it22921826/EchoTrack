package com.example.echotrack

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edit_profile)

        // Avatar image
        val imgAvatarEdit = findViewById<ImageView>(R.id.imgAvatarEdit)
        val btnChangeAvatar = findViewById<Button>(R.id.btnChangeAvatar)

        // Edit fields
        val etEditName = findViewById<EditText>(R.id.etEditName)
        val etEditEmail = findViewById<EditText>(R.id.etEditEmail)
        val etEditPassword = findViewById<EditText>(R.id.etEditPassword)

        // Buttons
        val btnSaveProfile = findViewById<Button>(R.id.btnSaveProfile)
        val btnCancelEdit = findViewById<Button>(R.id.btnCancelEdit)

        // Change Avatar function (logic for picking image not implemented, just a toast for now)
        btnChangeAvatar.setOnClickListener {
            Toast.makeText(this, "Change Avatar Clicked", Toast.LENGTH_SHORT).show()
            // Optionally: open image picker and set imgAvatarEdit.setImageURI() with result
        }

        // Save profile changes
        btnSaveProfile.setOnClickListener {
            val newName = etEditName.text.toString()
            val newEmail = etEditEmail.text.toString()
            val newPassword = etEditPassword.text.toString()

            // Here you'd perform validation and save logic (showing toast for demonstration)
            Toast.makeText(
                this,
                "Changes Saved:\nName: $newName\nEmail: $newEmail",
                Toast.LENGTH_LONG
            ).show()

            // After saving, you can finish or navigate back to profile page
            // finish()
        }

        // Cancel and go back
        btnCancelEdit.setOnClickListener {
            // Go back to previous screen (usually Profile page)
            finish()
        }
        findViewById<View>(R.id.btnChangeAvatar).setOnClickListener {
            val intent = Intent(this, ChangePhotoActivity::class.java)
            startActivity(intent)


        }

    }
}
