package com.example.myhousetestproj.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "doors")
data class Door(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String,
    val room: String,
    val snapshot: String
)
