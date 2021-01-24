package com.shop.net.repository

import com.bumptech.glide.request.BaseRequestOptions
import com.example.kotlinbase.net.repository.BaseRepository
import com.shop.api.SproutApi
import com.shop.net.RetrofitFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * 数据仓库
 * 用来连接ViewModel和Model
 * 定义业务相关的网络请求接口的api
 */
class SproutRepository:BaseRepository<SproutApi>(SproutApi::class.java) {

//    /**
//     * 加入购物车
//     */
//    suspend fun AddCar(map: HashMap<String, String>) = withContext(Dispatchers.IO){
//        serviceApi.AddCar(map)
//    }
//
    /**
     * 获取频道数据接口 给VM调用
     */
    suspend fun getChannel() = withContext(Dispatchers.IO){
        sproutapi.getChannel()
    }


    suspend fun getBrand(page:Int,size:Int) = withContext(Dispatchers.IO){
        sproutapi.getBrand(page,size)
    }

    suspend fun getGood(page:Int,size:Int) = withContext(Dispatchers.IO){
        sproutapi.getGood(page,size)
    }


}