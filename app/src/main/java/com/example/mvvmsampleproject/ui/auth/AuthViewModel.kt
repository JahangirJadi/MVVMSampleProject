package com.example.mvvmsampleproject.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmsampleproject.data.repositories.UserRepository
import com.example.mvvmsampleproject.utils.Coroutines

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

        Coroutines.main {
            val response = UserRepository().userLogin(email!!, password!!)
            if (response.isSuccessful) {
                listener?.onSuccess(response.body()?.user)
            } else {
                listener?.onFailure("Error code: ${response.code()}")
            }
        }

    }


}