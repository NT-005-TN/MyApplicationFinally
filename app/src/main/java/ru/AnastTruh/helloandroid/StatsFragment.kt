// StatsFragment.kt
package ru.AnastTruh.helloandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import ru.AnastTruh.helloandroid.databinding.FragmentStatsBinding

class StatsFragment : Fragment() {
    private var _binding: FragmentStatsBinding? = null
    private val binding get() = _binding!!
    private val args: StatsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentStatsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Отобразите статистику
        binding.tvStats.text = "Выполнено задач: ${args.done} из ${args.total}"

        // Постройте список задач
        val builder = StringBuilder()
        args.tasks?.forEach { task ->
            val prefix = if (task.isDone) "✅ " else "❌ "
            builder.append(prefix).append(task.title).append("\n")
        }

        // Отобразите список задач
        binding.tvTaskList.text = builder.toString()

        // Обработчик кнопки "Назад"
        binding.btnBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
