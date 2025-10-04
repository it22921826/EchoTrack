package com.example.echotrack

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ChangePhotoActivity : AppCompatActivity() {

    private lateinit var imgCurrentPhoto: ImageView
    private val GALLERY_REQUEST_CODE = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.change_photo)

        imgCurrentPhoto = findViewById(R.id.imgCurrentPhoto)
        val btnChoosePhoto = findViewById<Button>(R.id.btnChoosePhoto)
        val btnSavePhoto = findViewById<Button>(R.id.btnSavePhoto)
        val btnCancelPhoto = findViewById<Button>(R.id.btnCancelPhoto)

        btnChoosePhoto.setOnClickListener {
            // Open gallery to select image
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, GALLERY_REQUEST_CODE)
        }

        btnSavePhoto.setOnClickListener {
            Toast.makeText(this, "Photo saved!", Toast.LENGTH_SHORT).show()
            finish()
        }

        btnCancelPhoto.setOnClickListener {
            finish()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == GALLERY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val selectedImageUri: Uri? = data?.data
            if (selectedImageUri != null) {
                imgCurrentPhoto.setImageURI(selectedImageUri)
            } else {
                Toast.makeText(this, "No image selected.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
