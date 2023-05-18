package com.ilham.uklsemester2

import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(@PrimaryKey(autoGenerate = true)
                var id : Int = 0,
                var name : String,
                var username : String,
                var password : String,
                var jobdesk : String,
                var image: Int
                )
