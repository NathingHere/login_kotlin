package com.example.domain.usecase.login

import com.example.data.Either
import com.example.domain.provider.LoginProvider
import com.example.domain.usecase.base.BaseUseCaseWithParams

class CheckLoginUseCase(private val loginProvider: LoginProvider) : BaseUseCaseWithParams<Either<String, Boolean>, CheckLoginUseCase.LoginParams>{

    override suspend fun execute(params: LoginParams): Either<String, Boolean> = loginProvider.checkLogin(params.email, params.password)

    data class LoginParams(val email:String, val password:String)

}