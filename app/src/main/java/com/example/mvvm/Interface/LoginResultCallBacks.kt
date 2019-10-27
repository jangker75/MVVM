package com.example.mvvm.Interface

interface LoginResultCallBacks {
    fun onSuccess(message: String)
    fun onError(message: String)
}