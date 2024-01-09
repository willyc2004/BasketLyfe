package com.example.basketlyfe.repositories

import com.example.basketlyfe.service.MyDBService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MyDBContainer() {

    companion object{
        var EMAIL = ""
        var ACCESS_TOKEN = ""
        val Url = "https://0d34-182-1-96-32.ngrok-free.app"
    }

    private val BASE_URL = "$Url/api/"

    private val client = OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor(ACCESS_TOKEN))
            .build()

    private val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client)
            .build()

    private val retrofitService: MyDBService by lazy{
        retrofit.create(MyDBService::class.java)
    }

    val myDBRepositories: MyDBRepositories by lazy{
        MyDBRepositories(retrofitService)
    }
}