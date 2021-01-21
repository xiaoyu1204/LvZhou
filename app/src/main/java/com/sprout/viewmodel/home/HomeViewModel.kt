package com.sprout.viewmodel.home

import androidx.fragment.app.Fragment
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import com.sprout.ui.main.home.attention.AttentionFragment
import com.sprout.ui.main.home.local.LocalFragment
import com.sprout.ui.main.home.recommend.RecommendFragment

class HomeViewModel:BaseViewModel(Injection.repository) {

    var fragments:MutableList<Fragment> = mutableListOf()

    //添加进入集合
    init {
        fragments.add(AttentionFragment.instance)
        fragments.add(RecommendFragment.instance)
        fragments.add(LocalFragment.instance)
    }

}