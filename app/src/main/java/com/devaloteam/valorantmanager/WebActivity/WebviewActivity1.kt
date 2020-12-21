package com.devaloteam.valorantmanager.WebActivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.webkit.WebView
import androidx.appcompat.app.AppCompatActivity
import com.devaloteam.valorantmanager.WebActivity.UserWebClient

@SuppressLint("SetJavaScriptEnabled")

class WebviewActivity : AppCompatActivity() {

    private lateinit var mWebView: WebView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            setContentView(R.layout.activity_webview);

            mWebView = findViewById(R.id.activity_webview_main);
            mWebView.webViewClient = UserWebClient();


            val webSettings = mWebView.settings;
            webSettings.javaScriptEnabled = true;

            mWebView.loadUrl("https://epicgames.com/id/api/login?redirectUrl=https://epicgames.com/id/api/csrf");
        } catch (err: Exception) {
            val intent = Intent(this, AppErrorActivity::class.java);
            intent.putExtra("error", AppErrorActivity().stringifyError(err));
            startActivity(intent);
        }
    }

}