package com.sprout.ui.main.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.shop.base.BaseFragment
import com.sprout.R
import com.sprout.databinding.FragmentSearchBinding
import com.sprout.ui.main.home.HomeFragment
import com.sprout.viewmodel.search.SearchViewModel

//TODO 搜索页面
class SearchFragment : BaseFragment<SearchViewModel,FragmentSearchBinding>(R.layout.fragment_search,SearchViewModel::class.java) {

    //采用伴生对象 companion object==static 只能创建一次
    companion object {
        val instance by lazy { SearchFragment() }
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