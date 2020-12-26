package com.devaloteam.valorantmanager.LoginTest.main

import com.devaloteam.valorantmanager.LoginTest.model.Post
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginInterface {

    @POST("")
    suspend fun pushPost(
        @Body post: Post
    ): Response<Post>
}