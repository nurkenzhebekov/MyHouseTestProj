package com.example.myhousetestproj.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myhousetestproj.model.Door

@Dao
interface DoorDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(door: Door)

    @Query("SELECT * FROM doors")
    suspend fun getAllDoors(): List<Door>

    @Query("DELETE FROM doors")
    suspend fun deleteAllDoors()
}