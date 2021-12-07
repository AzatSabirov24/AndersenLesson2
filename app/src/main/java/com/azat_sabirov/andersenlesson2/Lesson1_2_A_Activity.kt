package com.azat_sabirov.andersenlesson2

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.azat_sabirov.andersenlesson2.databinding.ActivityLesson12AActivityBinding

class Lesson1_2_A_Activity : AppCompatActivity() {
    private lateinit var binding: ActivityLesson12AActivityBinding
    private var count: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLesson12AActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        btnOnClickListeners()
    }

    private fun btnOnClickListeners() = with (binding) {
        btnToast.setOnClickListener {
            Toast.makeText(this@Lesson1_2_A_Activity, getString(R.string.toast_text), Toast.LENGTH_SHORT).show()
        }

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