package com.best.mealsapp.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitApiClient {

    fun getInstance(): Retrofit {
//        val httpLoggingInterceptor = HttpLoggingInterceptor()
//            .setLevel(HttpLoggingInterceptor.Level.BODY)
//
//        val okHttpClient = OkHttpClient
//            .Builder()
//            .addInterceptor(httpLoggingInterceptor)
//            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            //.client(okHttpClient)
            .build()
    }

    private const val BASE_URL = "https://www.themealdb.com/api/json/v1/1/"
}