package com.sprout.ui.main.me

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shop.base.BaseFragment
import com.sprout.R
import com.sprout.databinding.FragmentMeBinding
import com.sprout.viewmodel.me.MeViewModel

//TODO 我的页面
class MeFragment : BaseFragment<MeViewModel,FragmentMeBinding>(R.layout.fragment_me,MeViewModel::class.java) {

    //采用伴生对象 companion object==static 只能创建一次
    companion object {
        val instance by lazy { MeFragment() }
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