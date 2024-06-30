package com.example.myhousetestproj.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myhousetestproj.data.DoorRepository
import com.example.myhousetestproj.model.Door
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DoorViewModel(private val repository: DoorRepository) : ViewModel() {

    private val _doors = MutableLiveData<List<Door>>()
    val doors: LiveData<List<Door>>
        get() = _doors

    init {
        loadDoors()
    }

    private fun loadDoors() {
        viewModelScope.launch(Dispatchers.IO) {
            val doorsFromDb = repository.getAllDoors()
            if (doorsFromDb.isEmpty()) {
                fetchDoorsFromApi()
            } else {
                _doors.postValue(doorsFromDb)
            }
        }
    }

    fun refreshData() {
        fetchDoorsFromApi()
    }

    private fun fetchDoorsFromApi() {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val doorsFromApi = repository.refreshDoors()
                _doors.postValue(doorsFromApi)
            } catch (e: Exception) {
                // Handle error
                e.printStackTrace()
            }
        }
    }

}