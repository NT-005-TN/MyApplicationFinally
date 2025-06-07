package ru.AnastTruh.helloandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.AnastTruh.helloandroid.databinding.ActivityTaskDetailBinding

class TaskDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTaskDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTaskDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val task = intent.getSerializableExtra("task") as Task
        binding.tvTitle.text = task.title
        binding.tvDescription.text = task.description
        binding.tvDueDate.text = task.dueDate
    }
}