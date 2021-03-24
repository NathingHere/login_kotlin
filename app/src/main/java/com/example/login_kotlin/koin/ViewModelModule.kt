package com.example.login_kotlin.koin

import com.example.domain.provider.LoginProvider
import com.example.domain.usecase.login.CheckLoginUseCase
import com.example.login_kotlin.ui.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    single {
        LoginProvider()
    }

    factory {
        CheckLoginUseCase(get())
    }

    viewModel {
        LoginViewModel(get())
    }
}