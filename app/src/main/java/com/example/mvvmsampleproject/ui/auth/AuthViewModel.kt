package com.example.mvvmsampleproject.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvmsampleproject.data.repositories.UserRepository
import com.example.mvvmsampleproject.utils.APIException
import com.example.mvvmsampleproject.utils.Coroutines
import com.example.mvvmsampleproject.utils.NoInternetException

class AuthViewModel(
    private val repository:UserRepository
) : ViewModel() {
    var email: String? = null
    var password: String? = null
    var listener: AuthListener? = null

    fun getLoggedInUser() = repository.getUser()

    fun onLoginButtonClicked(view: View) {
        listener?.onStarted()
        if (email.isNullOrEmpty() || password.isNullOrEmpty()) {
            //error
            listener?.onFailure("Invalid email or password")
            return
        }

        Coroutines.main {
            try {
                val response = repository.userLogin(email!!, password!!)
                response.user.let {
                    listener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }
                listener?.onFailure(response.message!!)
            } catch (e: APIException) {
                listener?.onFailure(e.message!!)
            }
            catch(e:NoInternetException){
                listener?.onFailure(e.message!!)
            }
        }

    }


}