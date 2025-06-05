package ru.AnastTruh.helloandroid

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class TaskAdapter(context: Context, tasks: List<Task>) :
    ArrayAdapter<Task>(context, 0, tasks) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_task, parent, false)

        val task = getItem(position)

        view.findViewById<TextView>(R.id.task_title).text = task?.title
        view.findViewById<TextView>(R.id.task_description).text = task?.description
        view.findViewById<TextView>(R.id.task_deadline).text = task?.deadline

        return view
    }
}