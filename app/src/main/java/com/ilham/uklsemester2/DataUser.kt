package com.ilham.uklsemester2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ilham.uklsemester2.databinding.ActivityDataUserBinding

class DataUser : AppCompatActivity() {

    private lateinit var binding : ActivityDataUserBinding
    private lateinit var userViewModel: UserViewModel
    private var user = ArrayList<User>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDataUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        userViewModel = ViewModelProvider(
            this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[UserViewModel::class.java]

        initUserRv()

        binding.dataUserIbBack.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.dataUserFabAdd.setOnClickListener {
            startActivity(Intent(this, AddUser::class.java))
            finish()
        }
    }

    private fun initUserRv(){


        val Useradapter = UserAdapter(this, user, userViewModel)

        val rvUser = binding.dataUserRvUser
        rvUser.setHasFixedSize(true)
        rvUser.layoutManager = LinearLayoutManager(this)
        rvUser.adapter = Useradapter

        userViewModel.getUser.observe(this) { list ->
            list?.let {
                user = it as ArrayList<User>
                Useradapter.updateFood(user)
            }
        }
    }

}