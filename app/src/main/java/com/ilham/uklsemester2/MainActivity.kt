package com.ilham.uklsemester2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ilham.uklsemester2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
                binding = ActivityMainBinding.inflate(layoutInflater)
                setContentView(binding.root)

        binding.cardMainBtnDatauser.setOnClickListener {
            startActivity(Intent(this, DataUser::class.java))
            finish()
        }

        binding.cardMainBtnMenu.setOnClickListener {
            startActivity(Intent(this, DataMenu::class.java))
            finish()
        }

        binding.cardMainBtnMeja.setOnClickListener {
            startActivity(Intent(this, DataMeja::class.java))
            finish()
        }
    }
}