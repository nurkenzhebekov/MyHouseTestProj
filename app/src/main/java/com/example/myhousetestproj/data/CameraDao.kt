package com.example.myhousetestproj.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myhousetestproj.model.Camera

@Dao
interface CameraDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(camera: Camera)

    @Query("SELECT * FROM cameras")
    suspend fun getAllCameras(): List<Camera>

    @Query("DELETE FROM cameras")
    suspend fun deleteAllCameras()
}