package ru.AnastTruh.helloandroid

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.AnastTruh.helloandroid.databinding.ActivityCreateTaskBinding

class CreateTaskActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCreateTaskBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCreate.setOnClickListener {
            val task = Task(
                binding.etTitle.text.toString(),
                binding.etDescription.text.toString(),
                binding.etDueDate.text.toString()
            )
            val intent = Intent()
            intent.putExtra("new_task", task)
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}