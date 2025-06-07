import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.AnastTruh.helloandroid.Task
import ru.AnastTruh.helloandroid.databinding.ItemTaskBinding

class TaskAdapter(
    private var tasks: List<Task>,
    private val onClick: (Task) -> Unit
) : RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private var filteredTasks: List<Task> = tasks.toList()

    class TaskViewHolder(val binding: ItemTaskBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val binding = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = filteredTasks[position]
        holder.binding.tvTitle.text = task.title
        holder.binding.tvDescription.text = task.description
        holder.binding.tvDescription.visibility = if (task.isExpanded) View.VISIBLE else View.GONE

        holder.binding.root.setOnClickListener {
            task.isExpanded = !task.isExpanded
            notifyItemChanged(position)
        }

        holder.binding.root.setOnLongClickListener {
            onClick(task)
            true
        }
    }

    override fun getItemCount(): Int = filteredTasks.size

    fun updateTasks(newTasks: List<Task>) {
        tasks = newTasks
        filteredTasks = newTasks
        notifyDataSetChanged()
    }

    fun filter(query: String?) {
        filteredTasks = if (query.isNullOrEmpty()) {
            tasks
        } else {
            tasks.filter { it.title.contains(query, ignoreCase = true) }
        }
        notifyDataSetChanged()
    }
}