package com.example.datasharedprefproject

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class DataStoreViewModel(private val repository: DataStoreRepository) : ViewModel() {

//    val repository: DataStoreRepository= DataStoreRepository(context = context)

    fun setFnameLname(fname: String, lname: String) {
        viewModelScope.launch {
            repository.setFnameLname(fname, lname)
        }
    }

    fun getFname():String{
        var fname = ""
        viewModelScope.launch {
            repository.getFirstName().collect{
                fname = it
            }
        }
        return fname
    }

    fun getLname(): String{
        var lname = ""
        viewModelScope.launch {
            repository.getLastName().collect{
                lname= it
            }
        }
        return lname
    }
}