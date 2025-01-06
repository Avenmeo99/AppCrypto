package com.example.appcrypto.Activity

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.appcrypto.Adapter.CryptoListAdapter
import com.example.appcrypto.ViewModel.MainViewModel
import com.example.appcrypto.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() { // Activity utama

    private lateinit var binding: ActivityMainBinding // Binding untuk layout
    private val viewModel: MainViewModel by viewModels() // ViewModel untuk data

    override fun onCreate(savedInstanceState: Bundle?) { // Saat activity dibuat
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater) // Inisialisasi binding
        setContentView(binding.root) // Set layout

        window.setFlags( // Fullscreen
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        initRecyclerViewCrypto() // Inisialisasi RecyclerView
    }

    private fun initRecyclerViewCrypto() { // Inisialisasi RecyclerView
        binding.view.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false) // Set layout manager
        binding.view.adapter =  CryptoListAdapter(viewModel.loadDatas()) // Set adapter dengan data dari ViewModel
    }
}