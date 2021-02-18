package com.example.mvvmsampleproject.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmsampleproject.R
import com.example.mvvmsampleproject.data.db.entities.User
import com.example.mvvmsampleproject.databinding.ActivityLoginBinding
import com.example.mvvmsampleproject.ui.home.HomeActivity
import com.example.mvvmsampleproject.utils.hide
import com.example.mvvmsampleproject.utils.show
import com.example.mvvmsampleproject.utils.snackbar
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance


class LoginActivity : AppCompatActivity(), AuthListener,KodeinAware {

    override val kodein by kodein()
    private val factory : AuthViewModelFactory by instance()

    private lateinit var binding: ActivityLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.listener = this

        viewModel.getLoggedInUser().observe(this, Observer { user ->

            if (user != null) {
                Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }

        })
    }

    override fun onStarted() {

        binding.progressBar.show()

    }

    override fun onSuccess(user: User?) {
        binding.progressBar.hide()
//        binding.rootLayout.snackbar("${user?.name} is logged in")
    }

    override fun onFailure(message: String) {
        binding.progressBar.hide()
        binding.rootLayout.snackbar(message)

    }
}