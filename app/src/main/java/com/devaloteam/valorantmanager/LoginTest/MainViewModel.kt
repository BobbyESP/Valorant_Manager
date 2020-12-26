package com.devaloteam.valorantmanager.LoginTest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.devaloteam.valorantmanager.LoginTest.model.Post
import com.devaloteam.valorantmanager.LoginTest.repository.Repository
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import retrofit2.Response


class MainViewModel(private val repository: Repository): ViewModel(){

    val myResponse: MutableLiveData<Response<Post>> = MutableLiveData()


    fun pushPost(post: Post){
        viewModelScope.launch {
            val response = repository.pushPost(post)
            myResponse.value = response
        }
    }
}