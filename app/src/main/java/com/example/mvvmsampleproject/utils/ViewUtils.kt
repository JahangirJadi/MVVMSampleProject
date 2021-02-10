package com.example.mvvmsampleproject.utils

import android.content.Context
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import android.widget.ProgressBar
import android.widget.Toast

fun Context.toast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}

fun ProgressBar.show(){
    visibility = VISIBLE
}

fun ProgressBar.hide(){
    visibility = INVISIBLE
}