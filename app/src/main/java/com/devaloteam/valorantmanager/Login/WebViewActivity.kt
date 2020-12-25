package com.devaloteam.valorantmanager.Login

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import com.devaloteam.valorantmanager.Errors.AppErrorActivity
import com.devaloteam.valorantmanager.R


@SuppressLint("SetJavaScriptEnabled")

class WebViewActivity : AppCompatActivity() {

    private lateinit var mWebView: WebView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_web_view)

            mWebView = findViewById(R.id.webViewLogin)
            mWebView = UserWebClient()

            val webSettings = mWebView.settings
            webSettings.javaScriptEnabled = true

            mWebView.loadUrl("auth.riotgames.com/login#client_id=play-valorant-web-prod&nonce=MTA0LDE0NSwyMjMs&redirect_uri=https%3A%2F%2Fplayvalorant.com%2Fopt_in&response_type=token%20id_token&scope=account%20openid&state=bG9naW4%3D")
        } catch (err: Exception) {
            val intent = Intent(this, AppErrorActivity::class.java);
            intent.putExtra("error", AppErrorActivity().stringifyError(err));
            startActivity(intent);
        }
    }
}