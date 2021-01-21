package com.sprout.ui.main.info

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shop.base.BaseFragment
import com.sprout.R
import com.sprout.databinding.FragmentInfoBinding
import com.sprout.viewmodel.info.InfoViewModel

//TODO 信息页面
class InfoFragment : BaseFragment<InfoViewModel,FragmentInfoBinding>(R.layout.fragment_info,InfoViewModel::class.java) {

    //采用伴生对象 companion object==static 只能创建一次
    companion object {
        val instance by lazy { InfoFragment() }
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