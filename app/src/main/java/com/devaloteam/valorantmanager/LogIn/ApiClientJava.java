package com.devaloteam.valorantmanager.LogIn;

import com.devaloteam.valorantmanager.LogIn.Cookies.Cookies;
import com.devaloteam.valorantmanager.LogIn.TestJava.AddCookiesInterceptor;
import com.devaloteam.valorantmanager.LogIn.TestJava.ReceivedCookiesInterceptor;
import android.content.Context;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClientJava {

    private static Retrofit getRetrofit(){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel((HttpLoggingInterceptor.Level.BODY));

        OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(httpLoggingInterceptor).build();

        OkHttpClient client = new OkHttpClient();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();

        client = builder.build();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("https://auth.riotgames.com/api/v1/authorization")
                .client(okHttpClient)
                .build();

        return retrofit;
    }

    public static Cookies getCookiesService(){
        Cookies cookies2 = getRetrofit().create(Cookies.class);

        return cookies2;
    }
}
