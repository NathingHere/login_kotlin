package com.example.login_kotlin.ui.login

import android.view.View
import android.widget.Toast
import com.example.login_kotlin.databinding.LoginLayoutBinding
import com.example.login_kotlin.ui.base.BaseFragment
import com.example.login_kotlin.ui.base.BaseViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<LoginLayoutBinding>() {

    private val viewModel by viewModel<LoginViewModel>()

    override fun initializeBinding(): LoginLayoutBinding {
        binding = LoginLayoutBinding.inflate(layoutInflater)
        return binding
    }

    override fun initView() {

        viewModel.init()

        with(binding) {
            btnLogin.setOnClickListener {
                setLogin()
            }
        }

        viewModel.loginLiveData.observe(viewLifecycleOwner) {
            manageScreenState(it)
        }

    }

    private fun manageScreenState(screenState: BaseViewModel.ScreenState<LoginViewModel.LoginState>) {
        when (screenState) {
            BaseViewModel.ScreenState.LOADING -> {
                binding.progressBar.visibility = View.VISIBLE
            }
            is BaseViewModel.ScreenState.RenderData -> manageLoginState(screenState.renderState)
        }
    }

    private fun manageLoginState(renderState: LoginViewModel.LoginState) {
        binding.progressBar.visibility = View.GONE
        when (renderState) {
            LoginViewModel.LoginState.Success -> {
                navController?.navigate(LoginFragmentDirections.actionLoginFragmentToHomeFragment())
            }
            is LoginViewModel.LoginState.Error -> {
                Toast.makeText(requireContext(), renderState.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setLogin() {
        val email = binding.user.text.toString()
        val password = binding.password.text.toString()

        viewModel.doLogin(email, password)
    }


}