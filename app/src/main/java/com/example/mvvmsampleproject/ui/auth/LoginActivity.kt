package com.example.mvvmsampleproject.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.*
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmsampleproject.R
import com.example.mvvmsampleproject.data.db.entities.User
import com.example.mvvmsampleproject.data.network.Response.AuthResponse
import com.example.mvvmsampleproject.databinding.ActivityLoginBinding
import com.example.mvvmsampleproject.utils.hide
import com.example.mvvmsampleproject.utils.show
import com.example.mvvmsampleproject.utils.toast

class LoginActivity : AppCompatActivity(), AuthListener {

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProvider(this).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.listener = this
    }

    override fun onStarted() {

       binding.progressBar.show()

    }

    override fun onSuccess(user:User?) {
        binding.progressBar.hide()
        toast("${user?.name} is logged in")
    }

    override fun onFailure(message: String) {
        binding.progressBar.hide()
        toast(message)
    }
}