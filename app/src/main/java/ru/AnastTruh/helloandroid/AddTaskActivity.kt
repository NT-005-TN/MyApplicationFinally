package ru.AnastTruh.helloandroid

import android.content.Intent
import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.prolificinteractive.materialcalendarview.MaterialCalendarView
import java.util.Locale


class AddTaskActivity : AppCompatActivity() {

    private lateinit var editTextTitle: EditText
    private lateinit var editTextDescription: EditText
    private lateinit var calendarView: MaterialCalendarView
    private lateinit var btnAddTask: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        editTextTitle = findViewById(R.id.editTextTitle)
        editTextDescription = findViewById(R.id.editTextDescription)
        calendarView = findViewById(R.id.calendarView)
        btnAddTask = findViewById(R.id.btnAddTask)

        btnAddTask.setOnClickListener {
            val title = editTextTitle.text.toString()
            val description = editTextDescription.text.toString()
            val selectedDate = calendarView.selectedDate

            if (title.isEmpty()) {
                Toast.makeText(this, "Введите название", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val deadline = selectedDate?.date?.let { date ->
                SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date)
            } ?: "Не указана"

            val intent = Intent().apply {
                putExtra("title", title)
                putExtra("description", description)
                putExtra("deadline", deadline)
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}