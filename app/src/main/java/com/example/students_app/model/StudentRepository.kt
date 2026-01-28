package com.example.students_app.model

object StudentRepository {
    val students: MutableList<Student> = ArrayList()

    init {
        students.add(Student("Ben", "123456", "054-1234567", "Tel Aviv", false))
        students.add(Student("Alice", "987654", "052-7654321", "Jerusalem", true))
        students.add(Student("David", "111222", "050-0000000", "Haifa", false))
    }

    fun addStudent(student: Student) {
        students.add(student)
    }

    fun removeStudent(index: Int) {
        if (index in 0 until students.size) {
            students.removeAt(index)
        }
    }

    fun updateStudent(index: Int, updatedStudent: Student) {
        if (index in 0 until students.size) {
            students[index] = updatedStudent
        }
    }
}