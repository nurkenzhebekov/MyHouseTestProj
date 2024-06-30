package com.example.myhousetestproj.data.remote

import com.example.myhousetestproj.model.Camera
import com.example.myhousetestproj.model.Door
import retrofit2.http.GET

interface ApiService {

    @GET("cameras/")
    suspend fun getCameras(): List<Camera>

    @GET("doors/")
    suspend fun getDoors(): List<Door>
}