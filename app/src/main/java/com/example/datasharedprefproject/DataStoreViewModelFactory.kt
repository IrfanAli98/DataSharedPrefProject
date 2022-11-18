package com.example.datasharedprefproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class DataStoreViewModelFactory(val repository: DataStoreRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DataStoreViewModel::class.java)){
            return DataStoreViewModel::class.java as T
        }
        throw IllegalArgumentException("Unknown class")
    }
}