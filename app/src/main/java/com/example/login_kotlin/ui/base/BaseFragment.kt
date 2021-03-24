package com.example.login_kotlin.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.viewbinding.ViewBinding
import com.example.login_kotlin.R

abstract class BaseFragment<BINDING : ViewBinding> :  Fragment(){

    protected lateinit var binding: BINDING

    protected val navController: NavController? by lazy { activity?.findNavController(R.id.fragment) }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return initializeBinding().root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    abstract fun initializeBinding(): BINDING

    abstract fun initView()

}