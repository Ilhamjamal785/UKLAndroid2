package com.ilham.uklsemester2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.ilham.uklsemester2.databinding.ActivityAddMejaBinding
import com.ilham.uklsemester2.databinding.ActivityAddMenuBinding

class AddMeja : AppCompatActivity() {
    private lateinit var binding : ActivityAddMejaBinding
    private lateinit var mejaViewModel: MejaViewModel
    private var variety = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMejaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()


        mejaViewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[MejaViewModel::class.java]

        binding.addMejaIbBack.setOnClickListener {
            startActivity(Intent(this, DataMeja::class.java ))
            finish()
        }


        binding.addMejaBtnSave.setOnClickListener{
            val noMeja = binding.addMejaEtName.text.toString()

            when{

                noMeja.isEmpty() -> alert()
                else -> {
                    mejaViewModel.insertMeja(Meja(no = noMeja.toInt()))
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