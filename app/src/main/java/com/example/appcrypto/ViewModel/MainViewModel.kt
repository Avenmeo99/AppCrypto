package com.example.appcrypto.ViewModel

import androidx.lifecycle.ViewModel
import com.example.appcrypto.Repository.MainRepository

class MainViewModel(val repository: MainRepository) : ViewModel() { // MainViewModel, turunan dari ViewModel
    // Primary constructor: menerima MainRepository
    constructor() : this(MainRepository()) // Secondary constructor: memanggil primary constructor dengan MainRepository baru

    fun loadDatas() = repository.items // Fungsi untuk mengambil data dari repository
}