package com.example.retrofit2

import People
import retrofit2.Response
import retrofit2.http.GET

interface RegresApi {
    @GET("/api/users?page=2")
    suspend fun getdata(): Response<People>
}