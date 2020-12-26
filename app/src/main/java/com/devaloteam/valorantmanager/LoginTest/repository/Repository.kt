package com.devaloteam.valorantmanager.LoginTest.repository

import com.devaloteam.valorantmanager.LoginTest.RetrofitInstance
import com.devaloteam.valorantmanager.LoginTest.model.Post
import retrofit2.Response
import retrofit2.Retrofit

class Repository {

    suspend fun pushPost(post: Post): Response<Post> {
        return RetrofitInstance.LogInterface.pushPost(post)
    }
}