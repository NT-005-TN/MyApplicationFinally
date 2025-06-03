package ru.AnastTruh.helloandroid

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import ru.anasttruh.helloandroid.R

class MainActivity : AppCompatActivity(){
    private val taskList = mutableListOf<String>()

    private lateinit var adapter: ArrayAdapter<String>
    private lateinit var listView: ListView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, taskList)

        listView = findViewById(R.id.tskListView)
        listView.adapter = adapter

        val button = findViewById<Button>(R.id.btnAddTask)
        button.setOnClickListener {
            val intent = Intent(this, AddTaskActivity::class.java)
            startActivityForResult(intent, 1)
        }

        val buttonStats = findViewById<Button>(R.id.btnStats)
        buttonStats.setOnClickListener {
            val intent = Intent(this, StatsActivity::class.java)
            startActivityForResult(intent, 1)
        }

    }

    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 1 && resultCode == RESULT_OK){
            val task = data?.getStringExtra("task")
            if (!task.isNullOrEmpty()){
                taskList.add(task)
                adapter.notifyDataSetChanged()
            }
        }
    }
}