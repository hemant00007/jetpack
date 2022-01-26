package com.example.kotlin_jetpack.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin_jetpack.repository.QuotesRepository

class MainviewModelFactory(private val repository: QuotesRepository): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
      return MainViewModel(repository) as T
    }
}