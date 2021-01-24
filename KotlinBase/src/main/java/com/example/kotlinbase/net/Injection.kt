package com.shop.net

import com.shop.net.repository.SproutRepository

/**
 * 数据仓库的代理类
 */
object Injection {
    // 创建数据仓库
    var repository:SproutRepository = SproutRepository()

    val myRepository by lazy {
//        Log.i("TAG","init")
        SproutRepository()
    }

}