// MainFragment.kt
package ru.AnastTruh.helloandroid

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import ru.AnastTruh.helloandroid.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    private val taskViewModel: TaskViewModel by viewModels({ requireActivity() })
    private lateinit var taskAdapter: TaskAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        taskAdapter = TaskAdapter(taskViewModel.tasks,
            onClick = { task ->
                val action = MainFragmentDirections.actionMainFragmentToTaskDetailFragment(task)
                findNavController().navigate(action)
            },
            onDelete = { task ->
                taskViewModel.removeTask(task)
                taskAdapter.updateTasks(taskViewModel.tasks)
            },
            onEdit = { task ->
                val index = taskViewModel.tasks.indexOf(task)
                val action = MainFragmentDirections.actionMainFragmentToCreateTaskFragment(task, index)
                findNavController().navigate(action)
            })

        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = taskAdapter
        }

        binding.btnNewTask.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToCreateTaskFragment(null, -1)
            findNavController().navigate(action)
        }

        binding.btnStats.setOnClickListener {
            val action = MainFragmentDirections.actionMainFragmentToStatsFragment(
                taskViewModel.doneCount,
                taskViewModel.totalCount,
                taskViewModel.tasks.toTypedArray()
            )
            findNavController().navigate(action)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.main_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_settings -> {
                // Обработка настроек
                true
            }
            R.id.menu_help -> {
                // Обработка помощи
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
