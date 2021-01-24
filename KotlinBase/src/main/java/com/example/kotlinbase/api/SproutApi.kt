package com.shop.api

import com.example.kotlinbase.model.bean.home.HomeChannelData
import com.example.kotlinbase.model.bean.issue.IssueBrandData
import com.example.kotlinbase.model.bean.issue.IssueGoodData
import com.shop.net.BaseResp
import retrofit2.http.GET
import retrofit2.http.Query

interface SproutApi {

//    //加入购物车
//    @POST("cart/add")
//    @FormUrlEncoded
//    suspend fun AddCar(@FieldMap map: HashMap<String, String>):BaseResp<CarAddBean>

    /**
     * 获取频道数据
     */
    @GET("channel/channel")
    suspend fun getChannel(): BaseResp<List<HomeChannelData>>

    /**
     * 加号里面的标签数据
     */
    @GET("tag/brand")
    suspend fun getBrand(@Query("page") page:Int, @Query("size") size:Int):BaseResp<IssueBrandData>

    @GET("tag/goods")
    suspend fun getGood(@Query("page") page:Int, @Query("size") size:Int):BaseResp<IssueGoodData>


}