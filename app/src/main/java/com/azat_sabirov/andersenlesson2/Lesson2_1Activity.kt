package com.azat_sabirov.andersenlesson2

import android.content.Intent
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.azat_sabirov.andersenlesson2.databinding.ActivityLesson21Binding

class Lesson2_1Activity : AppCompatActivity() {
    private lateinit var binding: ActivityLesson21Binding
    private var launcher: ActivityResultLauncher<Intent>? = null
    private var count = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLesson21Binding.inflate(layoutInflater)
        setContentView(binding.root)
        callbackFromSecondActivity()
        btnClickListeners()
    }

    private fun btnClickListeners() = with(binding) {
        btnSayHello.setOnClickListener {
            val i = Intent(this@Lesson2_1Activity, SecondActivity::class.java).apply {
                putExtra(EXTRA_COUNT, count)
            }
            launcher?.launch(i)
        }
        btnCount.setOnClickListener {
            count++
            tvCount.text = count.toString()
        }
    }

    private fun callbackFromSecondActivity() = with(binding) {
        launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
                if (result.resultCode == RESULT_OK) {
                    val reply = result.data?.getStringExtra(SecondActivity.EXTRA_REPLY)
                    tvCount.text = reply
                    reply?.let {
                        count = reply.toInt()
                    }
                }
            }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(EXTRA_COUNT, count)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) = with(binding) {
        super.onRestoreInstanceState(savedInstanceState)
        count = savedInstanceState.getInt(EXTRA_COUNT)
        tvCount.text = count.toString()
    }

    companion object {
        const val EXTRA_COUNT = "count"
    }
}