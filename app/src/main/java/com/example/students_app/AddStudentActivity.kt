package com.example.students_app

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.students_app.model.Student
import com.example.students_app.model.StudentRepository

class AddStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_student)

        val nameEt = findViewById<EditText>(R.id.add_name_et)
        val idEt = findViewById<EditText>(R.id.add_id_et)
        val phoneEt = findViewById<EditText>(R.id.add_phone_et)
        val addressEt = findViewById<EditText>(R.id.add_address_et)
        val checkBox = findViewById<CheckBox>(R.id.add_cb)

        val saveBtn = findViewById<Button>(R.id.add_save_btn)
        val cancelBtn = findViewById<Button>(R.id.add_cancel_btn)

        cancelBtn.setOnClickListener { finish() }

        saveBtn.setOnClickListener {
            val student = Student(
                name = nameEt.text.toString(),
                id = idEt.text.toString(),
                phone = phoneEt.text.toString(),
                address = addressEt.text.toString(),
                isChecked = checkBox.isChecked
            )
            StudentRepository.addStudent(student)
            finish()
        }
    }
}