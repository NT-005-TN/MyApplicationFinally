// TaskDetailFragment.kt
package ru.AnastTruh.helloandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import ru.AnastTruh.helloandroid.databinding.FragmentTaskDetailBinding

class TaskDetailFragment : Fragment() {
    private var _binding: FragmentTaskDetailBinding? = null
    private val binding get() = _binding!!
    private val args: TaskDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTaskDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val task = args.task
        binding.tvTitle.text = task.title
        binding.tvDescription.text = task.description
        binding.tvDueDate.text = task.dueDate
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
