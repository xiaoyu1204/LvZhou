package com.sprout.ui.main.home.local

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shop.base.BaseFragment
import com.sprout.R
import com.sprout.databinding.FragmentLocalBinding
import com.sprout.viewmodel.home.local.LocalViewModel

class LocalFragment : BaseFragment<LocalViewModel,FragmentLocalBinding>(R.layout.fragment_local,LocalViewModel::class.java) {

    //采用伴生对象 companion object==static 只能创建一次
    companion object {
        val instance by lazy { LocalFragment() }
    }

    override fun initView() {
    }

    override fun initVM() {
    }

    override fun initData() {
    }

    override fun initVariable() {
    }

}