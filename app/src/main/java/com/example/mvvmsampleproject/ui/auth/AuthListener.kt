package com.example.mvvmsampleproject.ui.auth

import com.example.mvvmsampleproject.data.db.entities.User

interface AuthListener {

    fun onStarted()
    fun onSuccess(user: User?)
    fun onFailure(message: String)
}