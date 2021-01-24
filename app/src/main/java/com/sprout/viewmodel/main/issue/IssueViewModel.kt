package com.sprout.viewmodel.main.issue

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kotlinbase.model.bean.issue.IssueBrandData
import com.example.kotlinbase.model.bean.issue.IssueGoodData
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import com.shop.net.repository.SproutRepository
import kotlinx.coroutines.launch

class IssueViewModel:BaseViewModel<SproutRepository>(Injection.repository) {

    var brandlist:MutableLiveData<IssueBrandData> = MutableLiveData()
    var goodlist:MutableLiveData<IssueGoodData> = MutableLiveData()

    //品牌
    fun getBrand(page:Int,size:Int){
        viewModelScope.launch {
            var result = repository.getBrand(page,size)
            if(result.errno == 0){
                brandlist.postValue(result.data)
            }
        }
    }

    //
    fun getGood(page:Int,size:Int){
        viewModelScope.launch {
            var result = repository.getGood(page,size)
            if(result.errno == 0){
                goodlist.postValue(result.data)
            }
        }
    }

}