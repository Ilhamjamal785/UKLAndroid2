package com.ilham.uklsemester2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.ilham.uklsemester2.databinding.ActivityUpdateMejaBinding
import com.ilham.uklsemester2.databinding.ActivityUpdateMenuBinding

class UpdateMeja : AppCompatActivity() {
    private lateinit var binding: ActivityUpdateMejaBinding
    private lateinit var mejaViewModel: MejaViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateMejaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.updateMejaIbBack.setOnClickListener {
            startActivity(Intent(this, DataMeja::class.java ))
            finish()
        }

        val id = intent.getIntExtra("id", 0)
        val noMeja = binding.updateMejaEtNo


        noMeja.setText(intent.getStringExtra("noMeja"))

        mejaViewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[MejaViewModel::class.java]

        binding.updateMejaBtnSave.setOnClickListener {
            val newNoMeja = noMeja.text.toString()

            when{

                newNoMeja.isEmpty() -> alert()

                else -> {
                        val updatedMeja = Meja(no = newNoMeja.toInt())
                        updatedMeja.id = id
                        mejaViewModel.updateMeja(updatedMeja)
                        startActivity(Intent(this, DataMeja::class.java))
                        finish()
                    }
                }
            }
        }

    private fun alert(){
        Toast.makeText(this, "Enter The Right Value", Toast.LENGTH_SHORT).show()
    }
}