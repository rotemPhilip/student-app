package com.example.students_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.students_app.model.StudentRepository

class StudentDetailsActivity : AppCompatActivity() {
    private var studentIndex: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_details)
        studentIndex = intent.getIntExtra("student_index", -1)

        findViewById<Button>(R.id.details_back_btn).setOnClickListener { finish() }
        findViewById<Button>(R.id.details_edit_btn).setOnClickListener {
            val intent = Intent(this, EditStudentActivity::class.java)
            intent.putExtra("student_index", studentIndex)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        if (studentIndex in 0 until StudentRepository.students.size) {
            val student = StudentRepository.students[studentIndex]

            findViewById<TextView>(R.id.details_name_tv).text = "Name: ${student.name}"
            findViewById<TextView>(R.id.details_id_tv).text = "ID: ${student.id}"
            findViewById<TextView>(R.id.details_phone_tv).text = "Phone: ${student.phone}"
            findViewById<TextView>(R.id.details_address_tv).text = "Address: ${student.address}"
            findViewById<CheckBox>(R.id.details_cb).isChecked = student.isChecked
        } else {
            finish()
        }
    }
}