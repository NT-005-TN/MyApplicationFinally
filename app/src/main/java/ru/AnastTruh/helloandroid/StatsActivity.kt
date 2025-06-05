package ru.AnastTruh.helloandroid

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.prolificinteractive.materialcalendarview.MaterialCalendarView


class StatsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        val totalTasks = intent.getIntExtra("totalTasks", 0)
        findViewById<TextView>(R.id.textTotalTasks).text =
            "Общее число задач: $totalTasks"

        // Дополнительно: можно передать список дат из задач и выделить их в календаре
        val calendarView = findViewById<MaterialCalendarView>(R.id.materialCalendarView)
        calendarView.selectionColor = ContextCompat.getColor(this, android.R.color.holo_blue_dark)
    }
}