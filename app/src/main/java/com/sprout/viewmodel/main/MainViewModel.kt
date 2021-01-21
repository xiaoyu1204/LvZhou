package com.sprout.viewmodel.main

import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import com.shop.base.BaseViewModel
import com.shop.net.Injection

class MainViewModel:BaseViewModel(Injection.repository){

    var fragments:MutableLiveData<Fragment> = MutableLiveData()

    //添加进入集合
    init {

    }

}