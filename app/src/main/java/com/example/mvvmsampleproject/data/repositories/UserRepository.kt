package com.example.mvvmsampleproject.data.repositories

import com.example.mvvmsampleproject.data.db.AppDatabase
import com.example.mvvmsampleproject.data.db.entities.User
import com.example.mvvmsampleproject.data.network.MyApi
import com.example.mvvmsampleproject.data.network.Response.AuthResponse
import com.example.mvvmsampleproject.data.network.SafeApiRequest
import retrofit2.Response

class UserRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {
    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }

    suspend fun saveUser(user: User?) = db.getUserDao().upsert(user)

     fun getUser() = db.getUserDao().getUser()
}