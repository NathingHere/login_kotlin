package com.example.login_kotlin.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.login_kotlin.R
import com.example.login_kotlin.databinding.ActivityMainBinding
import com.example.login_kotlin.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun initializedBinding(): ActivityMainBinding {
        binding = ActivityMainBinding.inflate(layoutInflater)
        return binding
    }

    override fun initView() {

    }

}