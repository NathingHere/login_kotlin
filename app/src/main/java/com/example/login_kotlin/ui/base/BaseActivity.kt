package com.example.login_kotlin.ui.base

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<BINDING : ViewBinding> : AppCompatActivity() {

    protected lateinit var binding: BINDING

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(initializedBinding().root)
        initView()
    }

    abstract fun initializedBinding() : BINDING

    abstract fun initView()

}