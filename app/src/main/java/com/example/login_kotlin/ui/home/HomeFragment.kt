package com.example.login_kotlin.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.login_kotlin.R
import com.example.login_kotlin.databinding.HomeLayoutBinding
import com.example.login_kotlin.databinding.LoginLayoutBinding
import com.example.login_kotlin.ui.base.BaseFragment

class HomeFragment : BaseFragment<HomeLayoutBinding>() {

    override fun initializeBinding(): HomeLayoutBinding {

        binding = HomeLayoutBinding.inflate(layoutInflater)
        return binding

    }

    override fun initView() {

    }

}