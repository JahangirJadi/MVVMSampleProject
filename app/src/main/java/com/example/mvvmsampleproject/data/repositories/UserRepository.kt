package com.example.mvvmsampleproject.data.repositories

import com.example.mvvmsampleproject.data.network.MyApi
import com.example.mvvmsampleproject.data.network.Response.AuthResponse
import com.example.mvvmsampleproject.data.network.SafeApiRequest
import retrofit2.Response

class UserRepository : SafeApiRequest() {
    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { MyApi().userLogin(email, password) }
    }

}