package com.devaloteam.valorantmanager.LogIn.Cookies

import android.telecom.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST

interface Cookies {

    @POST("")
    fun cookies(@Body cookieVars: CookieVars?): Call
}