package com.ilham.uklsemester2

import androidx.lifecycle.LiveData

class Reposi (private val kasirDao: KasirDao){
    val foods : LiveData<List<Food>> = kasirDao.getFood()
    val beverages : LiveData<List<Beverage>> = kasirDao.getBeverage()
    val meja : LiveData<List<Meja>> = kasirDao.getMeja()
    val users : LiveData<List<User>> = kasirDao.getUser()

    suspend fun insertFood(food: Food){
        kasirDao.insertFood(food)
    }

    suspend fun deleteFood(food: Food){
        kasirDao.deleteFood(food)
    }

    suspend fun updateFood(food: Food){
        kasirDao.updateFood(food)
    }

    suspend fun insertBeverage(beverage: Beverage){
        kasirDao.insertBeverage(beverage)
    }

    suspend fun deleteBeverage(beverage: Beverage){
        kasirDao.deleteBeverage(beverage)
    }

    suspend fun updateBeverage(beverage: Beverage){
        kasirDao.updateBeverage(beverage)
    }

    suspend fun insertUser(user: User){
        kasirDao.insertUser(user)
    }

    suspend fun deleteUser(user: User){
        kasirDao.deleteUser(user)
    }

    suspend fun updateUser(user: User){
        kasirDao.updateUser(user)
    }

    suspend fun insertMeja(meja: Meja){
        kasirDao.insertMeja(meja)
    }

    suspend fun deleteMeja(meja: Meja){
        kasirDao.deleteMeja(meja)
    }

    suspend fun updateMeja(meja: Meja){
        kasirDao.updateMeja(meja)
    }
}