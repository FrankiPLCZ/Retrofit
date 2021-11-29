package com.example.retrofit2

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    val api:RegresApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://reqres.in")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(RegresApi::class.java)
    }
}