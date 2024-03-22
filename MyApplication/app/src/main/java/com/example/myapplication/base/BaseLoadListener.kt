package com.example.myapplication.base

interface BaseLoadListener<T>{
    /**
     * 加载数据成功
     */
    fun loadSucess(list: T)

    /**
     * 加载失败
     */
    fun loadFailure(error: String)

}