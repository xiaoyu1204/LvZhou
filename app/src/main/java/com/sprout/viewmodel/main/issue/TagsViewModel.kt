package com.sprout.viewmodel.main.issue

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.kotlinbase.model.bean.issue.IssueBrandData
import com.example.kotlinbase.model.bean.issue.IssueGoodData
import com.shop.base.BaseViewModel
import com.shop.net.Injection
import com.shop.net.repository.SproutRepository
import kotlinx.coroutines.launch

class TagsViewModel:BaseViewModel<SproutRepository>(Injection.repository) {

    var bList:MutableLiveData<IssueBrandData> = MutableLiveData()
    var gList:MutableLiveData<IssueGoodData> = MutableLiveData()

    var bpage = 0
    var gpage = 0
    var size = 10

    fun getBrand(){
        viewModelScope.launch {
            var result = repository.getBrand(bpage,size)
            if(result.errno == 0){
                bList.postValue(result.data)
            }
        }
    }

    fun getGood(){
        viewModelScope.launch {
            var result = repository.getGood(gpage,size)
            if(result.errno == 0){
                gList.postValue(result.data)
            }
        }
    }

}