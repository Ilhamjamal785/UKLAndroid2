package com.ilham.uklsemester2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


    class MejaViewModel(application: Application) : AndroidViewModel(application) {
        val getMeja: LiveData<List<Meja>>
        val repository: Reposi

        init {
            val dao = AppDatabase.getDatabase(application).getKasirDao()
            repository = Reposi(dao)
            getMeja = repository.meja
        }

        fun insertMeja(meja: Meja) = viewModelScope.launch(Dispatchers.IO) {
            repository.insertMeja(meja)
        }

        fun deleteMeja(meja: Meja) = viewModelScope.launch(Dispatchers.IO) {
            repository.deleteMeja(meja)
        }

        fun updateMeja(meja: Meja) = viewModelScope.launch(Dispatchers.IO) {
            repository.updateMeja(meja)
        }

    }