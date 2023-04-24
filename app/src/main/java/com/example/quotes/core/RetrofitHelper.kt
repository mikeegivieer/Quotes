package com.example.quotes.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://quotes-13fd7-default-rtdb.firebaseio.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}