package com.example.kotlinbase.net.repository

import com.shop.net.RetrofitFactory

/**
 * 仓库基类 S为仓库对应的接口类
 */
open class BaseRepository<S>(
    cla:Class<S>
) {
    protected var sproutapi:S

    //初始化的方法
    init {
        sproutapi = RetrofitFactory.instance.create(cla)
    }
}