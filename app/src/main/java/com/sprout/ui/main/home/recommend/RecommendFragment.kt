package com.sprout.ui.main.home.recommend

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shop.base.BaseFragment
import com.sprout.R
import com.sprout.databinding.FragmentRecommendBinding
import com.sprout.viewmodel.home.recommend.RecommendViewModel


class RecommendFragment : BaseFragment<RecommendViewModel,FragmentRecommendBinding>(R.layout.fragment_recommend,RecommendViewModel::class.java) {

    //采用伴生对象 companion object==static 只能创建一次
    companion object {
        val instance by lazy { RecommendFragment() }
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