package com.example.myhousetestproj.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myhousetestproj.model.Camera

@Database(
    entities = [Camera::class], version = 1
)
abstract class CameraDatabase : RoomDatabase() {
    abstract fun cameraDao(): CameraDao
}