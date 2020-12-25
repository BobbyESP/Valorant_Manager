package com.devaloteam.valorantmanager.Login

import android.content.Intent
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import kotlin.concurrent.thread

class UserWebClient {
    private var entitltoken = ""
    private var AccsToken = ""
    private var cookies = ""

    @Override
    override fun shouldOverrideUrlLoading(view: WebView, url: String?) {
        try{
            if(url.toString().contains(""))
        }
    }
}