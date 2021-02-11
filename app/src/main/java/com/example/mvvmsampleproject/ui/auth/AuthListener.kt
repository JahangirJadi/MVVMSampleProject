package com.example.mvvmsampleproject.ui.auth

import com.example.mvvmsampleproject.data.db.entities.User
import com.example.mvvmsampleproject.data.network.Response.AuthResponse

interface AuthListener {

    fun onStarted()
    fun onSuccess(user: User?)
    fun onFailure(message: String)
}