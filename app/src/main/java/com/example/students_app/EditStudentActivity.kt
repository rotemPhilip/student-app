package com.example.students_app

import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.students_app.model.Student
import com.example.students_app.model.StudentRepository

class EditStudentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_student)
        val index = intent.getIntExtra("student_index", -1)

        val nameEt = findViewById<EditText>(R.id.edit_name_et)
        val idEt = findViewById<EditText>(R.id.edit_id_et)
        val phoneEt = findViewById<EditText>(R.id.edit_phone_et)
        val addressEt = findViewById<EditText>(R.id.edit_address_et)
        val checkBox = findViewById<CheckBox>(R.id.edit_cb)

        if (index in 0 until StudentRepository.students.size) {
            val student = StudentRepository.students[index]
            nameEt.setText(student.name)
            idEt.setText(student.id)
            phoneEt.setText(student.phone)
            addressEt.setText(student.address)
            checkBox.isChecked = student.isChecked
        }

        findViewById<Button>(R.id.edit_cancel_btn).setOnClickListener { finish() }

        findViewById<Button>(R.id.edit_delete_btn).setOnClickListener {
            StudentRepository.removeStudent(index)
            finish()
        }

        findViewById<Button>(R.id.edit_save_btn).setOnClickListener {
            val updatedStudent = Student(
                name = nameEt.text.toString(),
                id = idEt.text.toString(),
                phone = phoneEt.text.toString(),
                address = addressEt.text.toString(),
                isChecked = checkBox.isChecked
            )
            StudentRepository.updateStudent(index, updatedStudent)
            finish()
        }
    }
}