package com.example.mmthapp.Activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.mmthapp.MainActivity
import com.example.mmthapp.R
import com.example.mmthapp.databinding.ActivityIntroPageBinding

class IntroPage : BaseActivity() {
    private lateinit var binding: ActivityIntroPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityIntroPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button.setOnClickListener {
            startActivity(Intent(this@IntroPage, MainActivity::class.java))
        }

    }
}