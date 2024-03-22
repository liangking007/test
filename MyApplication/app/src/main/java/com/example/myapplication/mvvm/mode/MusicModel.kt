package com.example.myapplication.mvvm.mode

import com.example.myapplication.net.ApiClient
import com.example.myapplication.base.BaseLoadListener
import com.example.myapplication.bean.MusicBase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers


class MusicModel: IMusicModel {
    override fun loadMusicList(loadListener: BaseLoadListener<List<MusicBase>>) {
        val apiService = ApiClient().getApiService()
        apiService!!.getMusicList()
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({ result ->
                    var result : List<MusicBase>  = result.results!!
                    loadListener.loadSucess(result)
                },
                {
                    error ->  loadListener.loadFailure(error.message!!)
                }
        )








    }
}