package com.example.basketlyfe.service


import com.example.basketlyfe.model.ApiResponse
import com.example.basketlyfe.model.User
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.POST
import retrofit2.http.Path

interface MyDBService {
    @POST("login")
    suspend fun login(@Body user: User): ApiResponse

    @DELETE("logout")
    suspend fun logout(): ApiResponse

    @POST("create_user")
    suspend fun register(@Body user: User): ApiResponse

    @PATCH("getUserData")
    suspend fun getUserData(@Body user: User): ApiResponse

    @GET("showCourts")
    suspend fun getCourts(): ApiResponse

    @GET("court/{Id}")
    suspend fun getCourtById(@Path("id") id: Int): ApiResponse
}