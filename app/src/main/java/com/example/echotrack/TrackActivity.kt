package com.example.echotrack

import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class TrackActivity : AppCompatActivity() {
    private val activityHistory = mutableListOf<String>()
    private var selectedDate: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.track)

        val etActivity = findViewById<EditText>(R.id.etActivity)
        val btnSelectDate = findViewById<Button>(R.id.btnSelectDate)
        val tvDateSelected = findViewById<TextView>(R.id.tvDateSelected)
        val btnSaveTrack = findViewById<Button>(R.id.btnSaveTrack)
        val tvLastActivity = findViewById<TextView>(R.id.tvLastActivity)
        val tvSecondLastActivity = findViewById<TextView>(R.id.tvSecondLastActivity)

        // Handle date selection with a calendar
        btnSelectDate.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this, { _, y, m, d ->
                // Format selected date (e.g., 22 Aug 2025)
                val months = arrayOf(
                    "Jan", "Feb", "Mar", "Apr", "May", "Jun",
                    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"
                )
                selectedDate = "$d ${months[m]} $y"
                tvDateSelected.text = "Selected: $selectedDate"
            }, year, month, day)
            datePickerDialog.show()
        }

        // Handle activity saving
        btnSaveTrack.setOnClickListener {
            val activityText = etActivity.text.toString().trim()
            if (activityText.isNotEmpty() && selectedDate.isNotEmpty()) {
                val activityLine = "• $activityText - $selectedDate"
                activityHistory.add(0, activityLine)

                // Update recent activities display
                tvLastActivity.text = activityHistory.getOrNull(0) ?: ""
                tvSecondLastActivity.text = activityHistory.getOrNull(1) ?: ""

                // Clear input fields
                etActivity.text.clear()
                tvDateSelected.text = "No date selected"
                selectedDate = ""

                Toast.makeText(this, "Activity Saved!", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Please enter activity and select date!", Toast.LENGTH_SHORT).show()
            }
            findViewById<View>(R.id.btnSaveTrack).setOnClickListener {
                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)


            }
        }
    }
}
