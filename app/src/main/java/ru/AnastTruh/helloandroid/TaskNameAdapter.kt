package ru.AnastTruh.helloandroid

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.AnastTruh.helloandroid.Task
import ru.AnastTruh.helloandroid.databinding.ItemTaskNameBinding

class TaskNameAdapter(
    private var tasks: List<Task>,
    private val onClick: (Task) -> Unit
) : RecyclerView.Adapter<TaskNameAdapter.TaskNameViewHolder>() {

    inner class TaskNameViewHolder(val binding: ItemTaskNameBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskNameViewHolder {
        val binding = ItemTaskNameBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return TaskNameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskNameViewHolder, position: Int) {
        val task = tasks[position]
        holder.binding.tvTaskName.text = task.title
        holder.binding.root.setOnClickListener { onClick(task) }
    }

    override fun getItemCount() = tasks.size

    fun updateTasks(newTasks: List<Task>) {
        tasks = newTasks
        notifyDataSetChanged()
    }
}