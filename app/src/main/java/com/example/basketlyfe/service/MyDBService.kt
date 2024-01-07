package com.example.basketlyfe.service


import com.example.basketlyfe.model.ApiResponse
import com.example.basketlyfe.model.User
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.POST

interface MyDBService {
    @POST("login")
    suspend fun login(@Body user: User): ApiResponse

    @DELETE("logout")
    suspend fun logout(): ApiResponse

    @POST("create_user")
    suspend fun register(@Body user: User): ApiResponse
}