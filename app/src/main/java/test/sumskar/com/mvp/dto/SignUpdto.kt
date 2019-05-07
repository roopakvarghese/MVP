package test.sumskar.com.mvp.dto

import android.text.TextUtils

public class SignUpdto {

    fun getUsername(): String {
        return username
    }

    fun setUsername(username: String) {
        this.username = username
    }

    fun getPassword(): String {
        return password
    }

    fun setPassword(password: String) {
        this.password = password
    }

    fun getEmail(): String {
        return email
    }

    fun setEmail(email: String) {
        this.email = email
    }

     internal lateinit  var username: String
     internal lateinit var password: String
     internal lateinit var email: String

}