package ru.AnastTruh.helloandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.AnastTruh.helloandroid.databinding.ActivityStatsBinding

class StatsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityStatsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStatsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val done = intent.getIntExtra("done", 0)
        val total = intent.getIntExtra("total", 0)

        binding.tvStats.text = getString(R.string.stats_text, done, total)
        binding.btnBack.setOnClickListener {
            finish()
        }
    }
}