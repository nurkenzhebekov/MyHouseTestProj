package com.example.myhousetestproj.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhousetestproj.CameraRepository
import com.example.myhousetestproj.model.Camera
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CameraViewModel(private val repository: CameraRepository) : ViewModel() {

    private val _cameras = MutableLiveData<List<Camera>>()
    val cameras: LiveData<List<Camera>> get() = _cameras

    init {
        loadCameras()
    }

    private fun loadCameras() {
        viewModelScope.launch(Dispatchers.IO) {
            val camerasFromDb = repository.getAllCameras()
            if (camerasFromDb.isEmpty()) {
                fetchCamerasFromApi()
            } else {
                _cameras.postValue(camerasFromDb)
            }
        }
    }

    fun refreshData() {
        fetchCamerasFromApi()
    }

    private fun fetchCamerasFromApi() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val camerasFromApi = repository.refreshCameras()
                _cameras.postValue(camerasFromApi)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}