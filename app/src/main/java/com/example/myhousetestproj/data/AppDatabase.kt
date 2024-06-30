package com.example.myhousetestproj.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myhousetestproj.model.Camera
import com.example.myhousetestproj.model.Door

@Database(
    entities = [Camera::class, Door::class], version = 1
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun cameraDao(): CameraDao
    abstract fun doorDao(): DoorDao
}