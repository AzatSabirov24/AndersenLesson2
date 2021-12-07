package com.azat_sabirov.andersenlesson2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.azat_sabirov.andersenlesson2.databinding.ActivityLesson12BActivityBinding

class Lesson1_2_B_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityLesson12BActivityBinding
    private val COUNT_DEFAULT = "0"
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLesson12BActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnOnClickListeners()
    }

    private fun btnOnClickListeners() = with(binding) {
        btnToast?.setOnClickListener {
            Toast.makeText(
                this@Lesson1_2_B_Activity,
                getString(R.string.toast_text),
                Toast.LENGTH_SHORT
            ).show()
        }

        btnCount.setOnClickListener {
            count = tvCount.text.toString().toInt()
            count++
            tvCount.text = count.toString()
        }

        btnZero.setOnClickListener {
            tvCount.text = COUNT_DEFAULT
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