package com.ilham.uklsemester2

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface KasirDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFood(food: Food)

    @Delete
    suspend fun deleteFood(food: Food)

    @Update
    suspend fun updateFood(food: Food)

    @Query("SELECT * FROM food ORDER BY name ASC")
    fun getFood(): LiveData<List<Food>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertBeverage(beverage: Beverage)

    @Delete
    suspend fun deleteBeverage(beverage: Beverage)

    @Update
    suspend fun updateBeverage(beverage: Beverage)

    @Query("SELECT * FROM beverage ORDER BY name ASC")
    fun getBeverage(): LiveData<List<Beverage>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertMeja(meja: Meja)

    @Delete
    suspend fun deleteMeja(meja: Meja)

    @Update
    suspend fun updateMeja(meja: Meja)

    @Query("SELECT * FROM meja ORDER BY no ASC")
    fun getMeja(): LiveData<List<Meja>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Query("SELECT * FROM user ORDER BY name ASC")
    fun getUser(): LiveData<List<User>>

}
