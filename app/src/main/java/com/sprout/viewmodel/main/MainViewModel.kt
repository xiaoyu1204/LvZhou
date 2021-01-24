package com.sprout.viewmodel.main

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import com.sprout.ui.main.home.HomeFragment
import com.sprout.ui.main.info.InfoFragment
import com.sprout.ui.main.me.MeFragment
import com.sprout.ui.main.search.SearchFragment

class MainViewModel:BaseViewModel<Any?>(Injection.repository){

    var fragments:MutableList<Fragment> = mutableListOf()

    //添加进入集合
    init {
        fragments.add(HomeFragment.instance)
        fragments.add(SearchFragment.instance)
        fragments.add(InfoFragment.instance)
        fragments.add(MeFragment.instance)
    }

}