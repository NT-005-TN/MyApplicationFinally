package ru.AnastTruh.helloandroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import ru.anasttruh.helloandroid.R

class StatsActivity : AppCompatActivity() {

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_stats)

        val total = intent.getIntExtra("total", 0)
        val completed = intent.getIntExtra("completed", 0)

        findViewById<TextView>(R.id.textTotalTasks).text =
            "Всего задач: $total"

        findViewById<TextView>(R.id.textCompletedTasks).text =
            "Выполнено: $completed"

        val button = findViewById<Button>(R.id.btnMainMenu)
        button.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivityForResult(intent, 1)
        }
    }
}