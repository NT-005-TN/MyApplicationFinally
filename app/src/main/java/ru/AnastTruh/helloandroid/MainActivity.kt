package ru.AnastTruh.helloandroid

import TaskAdapter
import TaskNameAdapter
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import ru.AnastTruh.helloandroid.databinding.ActivityMainBinding
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    val taskList = mutableListOf(
        Task("Купить продукты", "Хлеб, молоко, яйца", "2025-06-10"),
        Task("Подготовиться к экзамену", "Прочитать 3 главы", "2025-06-12"),
        Task("Позвонить бабушке", "Уточнить рецепт пирога", "2025-06-08"),
        Task("Сделать проект", "Планировщик задач", "2025-06-15"),
        Task("Посмотреть фильм", "Фильм Нолана", "2025-06-11"),
        Task("Вынести мусор", "Не забыть про батарейки", "2025-06-09"),
        Task("Погулять с собакой", "30 минут прогулки", "2025-06-10"),
        Task("Починить баг", "В приложении падает экран", "2025-06-13"),
        Task("Сходить в спортзал", "Силовая тренировка", "2025-06-14"),
        Task("Записаться на курс", "Android разработка", "2025-06-16")
    )

    private val createTaskLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val newTask = result.data?.getSerializableExtra("new_task") as? Task
            newTask?.let {
                taskList.add(it)
                taskAdapter.updateTasks(taskList)
                nameAdapter.updateTasks(taskList)
            }
        }
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var nameAdapter: TaskNameAdapter
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Инициализируем адаптеры
        taskAdapter = TaskAdapter(taskList) { task ->
            val intent = Intent(this, TaskDetailActivity::class.java)
            intent.putExtra("task", task)
            startActivity(intent)
        }

        nameAdapter = TaskNameAdapter(taskList) { task ->
            val intent = Intent(this, TaskDetailActivity::class.java)
            intent.putExtra("task", task)
            startActivity(intent)
        }

        // Основной список задач
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = taskAdapter

        // Список только с названиями задач
        binding.recyclerViewNames.layoutManager = LinearLayoutManager(this)
        binding.recyclerViewNames.adapter = nameAdapter

        // Обновляем списки (не обязательно здесь, но можно оставить как пример)
        taskAdapter.updateTasks(taskList)
        nameAdapter.updateTasks(taskList)

        // Кнопка "Создать задачу"
        binding.btnNewTask.setOnClickListener {
            val intent = Intent(this, CreateTaskActivity::class.java)
            createTaskLauncher.launch(intent)
        }

        // Кнопка статистики
        binding.btnStats.setOnClickListener {
            val done = taskList.count { it.isDone }
            val intent = Intent(this, StatsActivity::class.java).apply {
                putExtra("done", done)
                putExtra("total", taskList.size)
            }
            startActivity(intent)
        }
    }
}