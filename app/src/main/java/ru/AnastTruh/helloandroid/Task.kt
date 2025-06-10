package ru.AnastTruh.helloandroid

import java.io.Serializable

data class Task(
    var title: String,
    var description: String,
    var dueDate: String,
    var isDone: Boolean = false,
    var isExpanded: Boolean = false
) : Serializable