package com.devaloteam.valorantmanager.LoginTest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.devaloteam.valorantmanager.LoginTest.repository.Repository

class MainViewModelFactory(
    private val repository: Repository
    ): ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}