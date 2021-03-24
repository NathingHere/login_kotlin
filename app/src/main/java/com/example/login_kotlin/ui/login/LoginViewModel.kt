package com.example.login_kotlin.ui.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.data.fold
import com.example.domain.usecase.login.CheckLoginUseCase
import com.example.login_kotlin.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class LoginViewModel(private val checkLoginUseCase: CheckLoginUseCase) : BaseViewModel() {

    sealed class LoginState {
        object Success : LoginState()
        data class Error(val message: String) : LoginState()
    }

    private val _loginMutableData = MutableLiveData<ScreenState<LoginState>>()
    val loginLiveData: LiveData<ScreenState<LoginState>>
        get() = _loginMutableData

    fun doLogin(email: String, password: String) {
        updateUI(ScreenState.LOADING)
        val params = CheckLoginUseCase.LoginParams(email, password)
        viewModelScope.launch {
            checkLoginUseCase.execute(params).fold({
                updateUI(ScreenState.RenderData(LoginState.Error(it)))
            }, {
                updateUI(ScreenState.RenderData(LoginState.Success))
            })
        }
    }

    private fun updateUI(state: ScreenState<LoginState>) {
        _loginMutableData.postValue(state)
    }

}