package com.example.basketlyfe.repositories

import com.example.basketlyfe.model.ApiResponse
import com.example.basketlyfe.model.User
import com.example.basketlyfe.service.MyDBService

class MyDBRepositories(private val myDBService: MyDBService) {

    suspend fun login(email: String, password: String): ApiResponse {
        val user = User(email = email, password = password)
        return myDBService.login(user)
    }

    suspend fun logout(): ApiResponse {
        return myDBService.logout()
    }

    suspend fun register(user: User): ApiResponse{
        return myDBService.register(user)
    }

    suspend fun update_user(user: User): User{
        val result = myDBService.update_user(user)
        return result
    }
}