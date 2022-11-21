package com.example.datasharedprefproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.datasharedprefproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var dataBinding : ActivityMainBinding
    private lateinit var viewModel: DataStoreViewModel
    private lateinit var factory: DataStoreViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        factory = DataStoreViewModelFactory(DataStoreRepository(this))
        viewModel = ViewModelProvider(this, factory)[DataStoreViewModel::class.java]


        dataBinding.btnSubmit.setOnClickListener (this)
    }

    override fun onClick(view: View?) {
        when(view!!.id){
            R.id.btn_submit->{
                viewModel.setFnameLname(dataBinding.etFirstName.text.toString(), dataBinding.etLastName.text.toString())
            }

            R.id.btn_Get->{
                var fname = viewModel.getFname()
                var lname = viewModel.getLname()
                dataBinding.tvName.text= "hello"+" "+fname+lname
            }
        }
    }
}