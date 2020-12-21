package com.devaloteam.valorantmanager.WebActivity

import android.content.Intent
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import okhttp3.OkHttpClient
import okhttp3.Request
import kotlin.concurrent.thread

class UserWebClient : WebViewClient() {
    private var xsrftoken = "";
    private var cookies = "";
    private var exchange = "";

    @Override
    override fun shouldOverrideUrlLoading(view: WebView, url: String?): Boolean {
        return false;
    };

    @Override
    override fun onPageFinished(view: WebView, url: String?) {
        try {
            if(url.toString().contains("https://www.epicgames.com/id/api/csrf")) {
                val manager = CookieManager.getInstance();
                val s = manager.getCookie(url);
                println(s)
                xsrftoken = s.replaceBefore("XSRF-TOKEN=", "").split(";")[0].split("=")[1]
                cookies = s;
                thread {
                    getExchangeCode(view);
                }
            }
        } catch (err: Exception) {
            val intent = Intent(view.context, AppErrorActivity::class.java);
            intent.putExtra("error", AppErrorActivity().stringifyError(err));
            view.context.startActivity(intent);
        }

    };

    private fun getExchangeCode(view: WebView): String {
        val client = OkHttpClient();

        // Get Exchange Code using POST
        try {

            if(exchange == "") {

                val newxsrfcookie = Request.Builder()
                    .url("https://www.epicgames.com/id/api/csrf")
                    .addHeader("Cookie", cookies)
                    .addHeader("X-XSRF-TOKEN", xsrftoken)
                    .get()
                    .build()

                val kek = client.newCall(newxsrfcookie).execute();
                val headers = kek.headers().toString();
                xsrftoken = headers.replaceBefore("XSRF-TOKEN", "").split(";")[0].replace("XSRF-TOKEN=", "");
                cookies = headers.replaceBefore("EPIC_SESSION_AP", "").split(";")[0];


                val request = Request.Builder()
                    .url("https://www.epicgames.com/id/api/exchange/generate")
                    .post(requestBody)
                    .addHeader("Cookie", cookies)
                    .addHeader("X-XSRF-TOKEN", xsrftoken)
                    .build()

                val res = client.newCall(request).execute();
                exchange = res.body()?.string().toString();
                println(exchange)
                val intent = Intent(view.context, DisplayCodeActivity::class.java);
                intent.putExtra("h", exchange)
                view.context.startActivity(intent);
            }

        } catch (err: Exception) {
            val intent = Intent(view.context, AppErrorActivity::class.java);
            intent.putExtra("error", AppErrorActivity().stringifyError(err));
            view.context.startActivity(intent);
        }
        return exchange;
    };


}