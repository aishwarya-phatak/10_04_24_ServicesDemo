package com.bitcode.a10_04_24_servicesdemo

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bitcode.a10_04_24_servicesdemo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private lateinit var intent: Intent
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.startService.setOnClickListener {
            val intent = Intent(this,MediaPlayerService::class.java)
            intent.putExtra("file_path",binding.edtPath.text.toString())
            startService(intent)
        }

        binding.stopService.setOnClickListener {
        val intent = Intent(this,MediaPlayerService::class.java)
            stopService(intent)
        }

    }
}