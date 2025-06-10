// CreateTaskFragment.kt
package ru.AnastTruh.helloandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ru.AnastTruh.helloandroid.databinding.FragmentCreateTaskBinding

class CreateTaskFragment : Fragment() {
    private var _binding: FragmentCreateTaskBinding? = null
    private val binding get() = _binding!!
    private val args: CreateTaskFragmentArgs by navArgs()
    private val taskViewModel: TaskViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCreateTaskBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val editMode = args.taskToEdit != null && args.taskPosition != -1

        if (editMode) {
            val task = args.taskToEdit!!
            binding.etTitle.setText(task.title)
            binding.etDescription.setText(task.description)
            binding.etDueDate.setText(task.dueDate)
            binding.btnCreate.text = "Сохранить изменения"
        }

        binding.btnCreate.setOnClickListener {
            val title = binding.etTitle.text.toString().trim()
            val description = binding.etDescription.text.toString().trim()
            val dueDate = binding.etDueDate.text.toString().trim()

            if (title.isEmpty() || description.isEmpty() || dueDate.isEmpty()) {
                Toast.makeText(requireContext(), "Все поля должны быть заполнены", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val task = Task(title, description, dueDate)
            if (editMode) {
                taskViewModel.updateTask(task, args.taskPosition)
            } else {
                taskViewModel.addTask(task)
            }

            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
