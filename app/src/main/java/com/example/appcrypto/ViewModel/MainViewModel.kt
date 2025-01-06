package com.example.appcrypto.ViewModel

import androidx.lifecycle.ViewModel
import com.example.appcrypto.Repository.MainRepository

class MainViewModel
    (val repository: MainRepository) :  ViewModel() {
         constructor():this(MainRepository())

    fun loadDatas() = repository.items
    }