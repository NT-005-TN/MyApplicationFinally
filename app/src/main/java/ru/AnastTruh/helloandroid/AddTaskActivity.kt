package ru.AnastTruh.helloandroid

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import ru.anasttruh.helloandroid.R

class AddTaskActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)

        val input = findViewById<EditText>(R.id.editTaskTitle)
        val button = findViewById<Button>(R.id.btnSaveTask)

        savedInstanceState?.let {
            input.setText(it.getString("task"))
        }

        button.setOnClickListener{
            val task = input.text.toString()
            if (task.isNotEmpty()){
                val result = Intent()
                result.putExtra("task", task)
                setResult(RESULT_OK, result)
                finish()
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("task", findViewById<EditText>(R.id.editTaskTitle).text.toString())
    }

}