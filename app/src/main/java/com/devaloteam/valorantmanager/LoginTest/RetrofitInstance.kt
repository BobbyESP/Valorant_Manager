package com.devaloteam.valorantmanager.LoginTest

import com.devaloteam.valorantmanager.LoginTest.main.LoginInterface
import com.devaloteam.valorantmanager.LoginTest.util.Constants.Companion.AUTHURL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(AUTHURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val LogInterface: LoginInterface by lazy {
        retrofit.create(LoginInterface::class.java)
    }
}