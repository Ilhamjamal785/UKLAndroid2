package com.ilham.uklsemester2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilham.uklsemester2.databinding.ActivityDataMejaBinding
import com.ilham.uklsemester2.databinding.ActivityDataMenuBinding

class DataMeja : AppCompatActivity() {
    private lateinit var binding : ActivityDataMejaBinding
    private lateinit var mejaViewModel: MejaViewModel
    private var tables = ArrayList<Meja>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataMejaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        mejaViewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[MejaViewModel::class.java]

        initMejaRv()

        binding.dataMejaIbBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.dataMejaFabAdd.setOnClickListener {
            startActivity(Intent(this, AddMeja::class.java))
            finish()
        }
    }

    private fun initMejaRv(){


        val mejaAdapter = MejaAdapter(this, tables, mejaViewModel = mejaViewModel)

        val rvMeja = binding.dataMejaRvMeja
        rvMeja.setHasFixedSize(true)
        rvMeja.layoutManager = LinearLayoutManager(this)
        rvMeja.adapter = mejaAdapter

        mejaViewModel.getMeja.observe(this) { list ->
            list?.let {
                tables = it as ArrayList<Meja>
                mejaAdapter.updateMeja(tables)
            }
        }
    }
}