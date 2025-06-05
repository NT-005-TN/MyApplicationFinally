package ru.AnastTruh.helloandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val taskList = mutableListOf<Task>()
    private lateinit var adapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        adapter = TaskAdapter(this, taskList)
        listView.adapter = adapter

        findViewById<Button>(R.id.btnAddTask).setOnClickListener {
            startActivityForResult(Intent(this, AddTaskActivity::class.java), 1)
        }

        findViewById<Button>(R.id.btnStats).setOnClickListener {
            val intent = Intent(this, StatsActivity::class.java)
            intent.putExtra("totalTasks", taskList.size)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            val title = data.getStringExtra("title")
            val description = data.getStringExtra("description")
            val deadline = data.getStringExtra("deadline")

            if (!title.isNullOrEmpty()) {
                taskList.add(Task(title, description ?: "", deadline ?: ""))
                adapter.notifyDataSetChanged()
            }
        }
    }
}