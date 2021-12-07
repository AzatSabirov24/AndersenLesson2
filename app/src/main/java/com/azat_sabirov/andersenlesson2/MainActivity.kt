package com.azat_sabirov.andersenlesson2

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.azat_sabirov.andersenlesson2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    val TAG = "MyLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        buttonsOnClickListeners()
    }

    private fun buttonsOnClickListeners() = with(binding) {
        btn11.setOnClickListener {
            val i = Intent(this@MainActivity, Lesson1_1Activity::class.java)
            startActivity(i)
        }
        btn12A.setOnClickListener {
            val i = Intent(this@MainActivity, Lesson1_2_A_Activity::class.java)
            startActivity(i)
        }
        btn12B.setOnClickListener {
            val i = Intent(this@MainActivity, Lesson1_2_B_Activity::class.java)
            startActivity(i)
        }
        btn13.setOnClickListener {
            val i = Intent(this@MainActivity, Lesson1_3_Activity::class.java)
            startActivity(i)
        }
        btn14.setOnClickListener {
            val i = Intent(this@MainActivity, Lesson1_4Activity::class.java)
            startActivity(i)
        }
        btn21.setOnClickListener {
            val i = Intent(this@MainActivity, Lesson2_1Activity::class.java)
            startActivity(i)
        }
        btn22.setOnClickListener {
            val i = Intent(this@MainActivity, Lesson2_2Activity::class.java)
            startActivity(i)
        }
        btn23.setOnClickListener {
            val i = Intent(this@MainActivity, Lesson2_3Activity::class.java)
            startActivity(i)
        }
    }
}