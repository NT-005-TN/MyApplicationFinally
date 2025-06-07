package ru.AnastTruh.helloandroid

import java.io.Serializable

data class Task(
    val title: String,
    val description: String,
    val dueDate: String,
    var isDone: Boolean = false,
    var isExpanded: Boolean = false // ← новое поле
) : Serializable