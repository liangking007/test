package com.example.myapplication.net


import com.example.myapplication.bean.BaseBean
import com.example.myapplication.bean.MusicBase
import io.reactivex.Observable
import retrofit2.http.GET

interface IRequest {
    @GET("search?term=歌&limit=200&country=HK")
    fun getMusicList(): Observable<BaseBean<List<MusicBase>>>
}