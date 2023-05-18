package com.ilham.uklsemester2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(application: Application): AndroidViewModel(application) {
    val getUser: LiveData<List<User>>
    val repository : Reposi

    init {
        val dao = AppDatabase.getDatabase(application).getKasirDao()
        repository = Reposi(dao)
        getUser = repository.users
    }

    fun insertUser(user: User) = viewModelScope.launch(Dispatchers.IO){
        repository.insertUser(user)
    }

    fun deleteUser(user: User) = viewModelScope.launch(Dispatchers.IO){
        repository.deleteUser(user)
    }

    fun updateUser(user: User) = viewModelScope.launch(Dispatchers.IO){
        repository.updateUser(user)
    }

}