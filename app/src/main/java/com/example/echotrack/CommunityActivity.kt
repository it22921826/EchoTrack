package com.example.echotrack

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.app.AlertDialog
import android.widget.EditText

class CommunityActivity : AppCompatActivity() {

    private val postList = mutableListOf(
        CommunityPost("Alice", "Tip: Use reusable bags!", "3 min ago"),
        CommunityPost("Bob", "Question: How to save energy at home?", "5 min ago"),
        CommunityPost("Cathy", "Shared: Walked to work today!", "10 min ago"),
        CommunityPost("Dave", "Challenge: 1 week no plastic!", "20 min ago")
    )
    private lateinit var communityAdapter: CommunityAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.community)

        // Setup RecyclerView and Adapter
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerCommunity)
        communityAdapter = CommunityAdapter(postList)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = communityAdapter

        // Plus FAB for adding a new post via dialog
        val fabAddPost = findViewById<FloatingActionButton>(R.id.fabAddPost)
        fabAddPost.setOnClickListener {
            // Show input dialog for new post
            val inputField = EditText(this)
            inputField.hint = "Enter your eco tip, question, or achievement"

            AlertDialog.Builder(this)
                .setTitle("Add New Post")
                .setView(inputField)
                .setPositiveButton("Add") { _, _ ->
                    val text = inputField.text.toString().trim()
                    if (text.isNotEmpty()) {
                        val newPost = CommunityPost("You", text, "now")
                        postList.add(0, newPost)
                        communityAdapter.notifyItemInserted(0)
                        recyclerView.scrollToPosition(0)
                        Toast.makeText(this, "Post added!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Please enter something!", Toast.LENGTH_SHORT).show()
                    }
                }
                .setNegativeButton("Cancel", null)
                .show()
        }

        // Button to go to the Home Activity
        val btnGoHome = findViewById<Button>(R.id.btnGoHome)
        btnGoHome.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}