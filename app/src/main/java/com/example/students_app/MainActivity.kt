package com.example.students_app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.students_app.model.StudentRepository

class MainActivity : AppCompatActivity() {

    private var adapter: StudentAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler: RecyclerView = findViewById(R.id.main_recycler)
        val addBtn: Button = findViewById(R.id.main_add_btn)

        recycler.layoutManager = LinearLayoutManager(this)

        adapter = StudentAdapter(StudentRepository.students) { position ->
            val intent = Intent(this, StudentDetailsActivity::class.java)
            intent.putExtra("student_index", position)
            startActivity(intent)
        }

        recycler.adapter = adapter

        addBtn.setOnClickListener {
            val intent = Intent(this, AddStudentActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        adapter?.notifyDataSetChanged()
    }
}