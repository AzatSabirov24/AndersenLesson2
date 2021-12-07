package com.azat_sabirov.andersenlesson2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.azat_sabirov.andersenlesson2.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showMessage()
        replyFromSecondActivity()
    }

    private fun showMessage() = with(binding){
        val countFromParentActivity = intent.getIntExtra(Lesson2_1Activity.EXTRA_COUNT, 0)
        tvCount.text = countFromParentActivity.toString()
    }

    private fun replyFromSecondActivity() = with(binding){
        btnReplyMessage.setOnClickListener {
            val reply = etMessageForReply.text.toString()
            val intent = Intent().apply {
                putExtra(EXTRA_REPLY, reply)
            }
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    companion object {
        const val EXTRA_REPLY = "reply_message"
    }
}