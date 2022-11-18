package com.example.datasharedprefproject

import androidx.datastore.preferences.core.stringPreferencesKey

class Keys {
    companion object{
        val Fname = stringPreferencesKey("fname")
        val Lname = stringPreferencesKey("lname")
     }
}