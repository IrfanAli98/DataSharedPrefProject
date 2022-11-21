package com.example.datasharedprefproject

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map

class DataStoreRepository(val context: Context) {

    val Context.dataStore: DataStore<Preferences> by preferencesDataStore("DataStorePrefs")

    suspend fun setFnameLname(fname: String, lname: String){
        context.dataStore.edit {
            it[Keys.Fname]=fname
            it[Keys.Lname]=lname
        }
    }

    fun getFirstName()=
        context.dataStore.data.map {
            it[Keys.Fname]?:"Unknown".toString()
        }

    fun getLastName()=
        context.dataStore.data.map {
            it[Keys.Lname]?:"Unknown".toString()
        }

}