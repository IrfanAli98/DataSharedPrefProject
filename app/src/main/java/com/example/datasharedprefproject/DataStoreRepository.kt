package com.example.datasharedprefproject

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore

class DataStoreRepository(val context: Context) {

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore("DataStorePrefs")

    suspend fun setFnameLname(fname: String, lname: String){
        context.dataStore.edit {
            it[Keys.Fname]=fname
            it[Keys.Lname]=lname
        }
    }
}