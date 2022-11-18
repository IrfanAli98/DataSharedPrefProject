package com.example.datasharedprefproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.datasharedprefproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var dataBinding : ActivityMainBinding
    private lateinit var viewModel: DataStoreViewModel
    private lateinit var factory: DataStoreViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this, factory)[DataStoreViewModel::class.java]
        factory = DataStoreViewModelFactory(DataStoreRepository(this))

        dataBinding.btnSubmit.setOnClickListener {
            suspend {viewModel.setFnameLname(dataBinding.etFirstName.text.toString(), dataBinding.etLastName.text.toString()) }

        }
    }
}