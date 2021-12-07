package com.azat_sabirov.andersenlesson2

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ShareCompat
import com.azat_sabirov.andersenlesson2.databinding.ActivityLesson23Binding

class Lesson2_3Activity : AppCompatActivity() {
    private lateinit var binding: ActivityLesson23Binding
    private val TAG = "MyLog"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLesson23Binding.inflate(layoutInflater)
        setContentView(binding.root)
        btnOnClickListeners()
    }

    @SuppressLint("QueryPermissionsNeeded")
    private fun btnOnClickListeners() = with(binding) {
        btnOpenWebsite.setOnClickListener {
            val url = etWebsite.text.toString()
            val webpage = Uri.parse(url)
            val intent = Intent(Intent.ACTION_VIEW, webpage)
            if (intent.resolveActivity(packageManager) != null) startActivity(intent)
            else Log.d(TAG, "Can't handle this intent!")
        }
        btnOpenLocation.setOnClickListener {
            val loc = etLocation.text.toString()
            val addressUri = Uri.parse("geo:0,0?q=$loc")
            val intent = Intent(Intent.ACTION_VIEW, addressUri)
            if (intent.resolveActivity(packageManager) != null) startActivity(intent)
            else Log.d(TAG, "Can't handle this intent!")
        }
        btnShareText.setOnClickListener {
            val txt = etShare.text.toString()
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(this@Lesson2_3Activity)
                .setType(mimeType)
                .setChooserTitle("Share this text with: ")
                .setText(txt)
                .startChooser()
        }
        btnCamera.setOnClickListener {
            val intentCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intentCamera)
        }
    }
}