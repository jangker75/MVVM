package com.example.mvvm.ViewModel

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModel
import com.example.mvvm.Interface.LoginResultCallBacks
import com.example.mvvm.model.User

class LoginViewModel(private val listener: LoginResultCallBacks) : ViewModel() {

    private val user: User

    init {
        this.user = User("", "")
    }

    //email text after user input
    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                user.setEmail(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }

    //password text after user input
    val passwordTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                user.setPassword(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

        }

    fun onLoginClicked(v: View) {
        if (user.isDataValid) {
            listener.onSuccess("Login Success")
        } else {
            listener.onError("Login Failed")
        }
    }
}