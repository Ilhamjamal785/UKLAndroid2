package com.ilham.uklsemester2

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Meja(@PrimaryKey(autoGenerate = true)
                var id : Int = 0, var no : Int)

