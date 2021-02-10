package com.example.mvvmsampleproject.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmsampleproject.data.repositories.UserRepository

class AuthViewModel : ViewModel() {
    var email: String? = null
    var password: String? = null
    var listener: AuthListener? = null

    fun onLoginButtonClicked(view: View) {
        listener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            //error
            listener?.onFailure("Invalid email or password")
            return
        }

        val loginResponse = UserRepository().userLogin(email!!,password!!)
        listener?.onSuccess(loginResponse)
    }


}