package com.example.appcrypto.Activity

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appcrypto.Adapter.CryptoListAdapter
import com.example.appcrypto.ViewModel.MainViewModel
import com.example.appcrypto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    window.setFlags(
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
        WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
    )

     initRecyclerViewCrypto()

    }

    private fun initRecyclerViewCrypto() {
     binding.view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.view.adapter =  CryptoListAdapter(viewModel.loadDatas())
    }
}