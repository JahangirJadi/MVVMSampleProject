package com.example.mvvmsampleproject.data.repositories

import com.example.mvvmsampleproject.data.network.MyApi
import com.example.mvvmsampleproject.data.network.Response.AuthResponse
import retrofit2.Response

class UserRepository {
    suspend fun userLogin(email: String, password: String): Response<AuthResponse> {
        return MyApi().userLogin(email, password)
    }

}