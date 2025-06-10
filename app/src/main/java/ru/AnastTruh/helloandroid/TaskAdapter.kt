package ru.AnastTruh.helloandroid

import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.AnastTruh.helloandroid.databinding.ItemTaskBinding

class TaskAdapter(
    private var tasks: List<Task>,
    private val onClick: (Task) -> Unit,
    private val onDelete: (Task) -> Unit,
    private val onEdit: (Task) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    inner class TaskViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = tasks[position]
        holder.binding.tvTitle.text = task.title
        holder.binding.tvDescription.text = task.description

        holder.binding.checkDone.setOnCheckedChangeListener(null)
        holder.binding.checkDone.isChecked = task.isDone

        holder.binding.tvTitle.paintFlags =
            if (task.isDone) Paint.STRIKE_THRU_TEXT_FLAG else 0

        holder.binding.checkDone.setOnCheckedChangeListener { _, isChecked ->
            task.isDone = isChecked
            holder.binding.tvTitle.paintFlags =
                if (isChecked) Paint.STRIKE_THRU_TEXT_FLAG else 0
        }

        holder.binding.btnDelete.setOnClickListener {
            onDelete(task)
        }

        holder.binding.btnEdit.setOnClickListener {
            onEdit(task)
        }

        holder.binding.root.setOnClickListener {
            onClick(task)
        }
    }

    override fun getItemCount(): Int = tasks.size

    fun updateTasks(newTasks: List<Task>) {
        tasks = newTasks
        notifyDataSetChanged()
    }
}
