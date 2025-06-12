// TaskViewModel.kt
package ru.AnastTruh.helloandroid

import androidx.lifecycle.ViewModel

class TaskViewModel : ViewModel() {
    private val _tasks = mutableListOf(
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
    val tasks: List<Task> get() = _tasks

    val doneCount: Int get() = _tasks.count { it.isDone }
    val totalCount: Int get() = _tasks.size

    fun addTask(task: Task) {
        _tasks.add(task)
    }

    fun updateTask(task: Task, index: Int) {
        if (index in _tasks.indices) {
            _tasks[index] = task
        }
    }

    fun removeTask(task: Task) {
        _tasks.remove(task)
    }
}
