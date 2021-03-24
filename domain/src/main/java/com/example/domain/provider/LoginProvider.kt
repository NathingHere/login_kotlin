package com.example.domain.provider

import com.example.data.Either
import com.example.data.value
import com.example.data.vanadisError

class LoginProvider {

    fun checkLogin(email:String, password:String) : Either<String, Boolean>{

        return if (email.isNotEmpty() && password.isNotEmpty()) {
            value(true)
        } else vanadisError("Faltan datos")

    }

    fun checkPassword(password:String) : Either<String, Boolean>{

        return if (password.length < 6) {
            value(true)
        } else vanadisError("La contraseña debe tener mas de 6 caracteres")

    }

}