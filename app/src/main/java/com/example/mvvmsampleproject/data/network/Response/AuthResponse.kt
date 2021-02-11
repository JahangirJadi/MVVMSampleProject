package com.example.mvvmsampleproject.data.network.Response

import com.example.mvvmsampleproject.data.db.entities.User

data class AuthResponse(
    var isSuccessful: Boolean?,
    var message: String?,
    var user: User?

)