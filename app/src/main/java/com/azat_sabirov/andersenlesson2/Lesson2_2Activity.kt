package com.azat_sabirov.andersenlesson2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.azat_sabirov.andersenlesson2.databinding.ActivityLesson22Binding

class Lesson2_2Activity : AppCompatActivity() {
    private lateinit var binding: ActivityLesson22Binding
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLesson22Binding.inflate(layoutInflater)
        setContentView(binding.root)
        btnOnClickListener()
    }

    private fun btnOnClickListener() = with(binding) {
        btnCount.setOnClickListener {
            count++
            tvCount.text = count.toString()
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(EXTRA_SAVE, count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt(EXTRA_SAVE)
        binding.tvCount.text = count.toString()
    }

    companion object {
        const val EXTRA_SAVE = "save"
    }
}