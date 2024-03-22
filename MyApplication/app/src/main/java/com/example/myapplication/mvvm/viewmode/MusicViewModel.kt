package com.example.myapplication.mvvm.viewmode

import android.util.Log
import com.example.myapplication.adapter.MusicAdapter
import com.example.myapplication.base.BaseLoadListener
import com.example.myapplication.base.IBaseView
import com.example.myapplication.bean.MusicBase
import com.example.myapplication.mvvm.mode.IMusicModel
import com.example.myapplication.mvvm.mode.MusicModel


class MusicViewModel(personView: IBaseView, adapter: MusicAdapter) :
    BaseLoadListener<List<MusicBase>> {
    private var mMusicView: IBaseView = personView
    private var mAdapter: MusicAdapter = adapter
    private var mMusicModel: IMusicModel? = null
    private var musicList: List<MusicBase>? = null

    init {
        mMusicModel = MusicModel()
        getFristData()
    }

    private fun getFristData() {
        mMusicModel!!.loadMusicList(this)
    }

    override fun loadSucess(list: List<MusicBase>) {
        musicList = list;
        mAdapter.refreshData(list)
        mMusicView.loadComplete()

    }

    override fun loadFailure(error: String) {
        mMusicView.loadFailure(error)

    }


    fun search(searchStr: String) {
        if (searchStr.isEmpty()) {
            musicList!!.let { mAdapter.refreshData(it) }
            mMusicView.loadComplete()
        } else {
            var tempMusicList: List<MusicBase>? = mutableListOf()
            musicList!!.forEach {
                if (tempMusicList != null) {
                    if (it.artistName!!.contains(searchStr) || it.trackName!!.contains(searchStr)) {
                        Log.wtf("TAG", "$it")
                        tempMusicList += it
                    }
                }

            }
            if (tempMusicList != null) {
                mAdapter.refreshData(tempMusicList)
                mMusicView.loadComplete()
            }

        }

    }

    fun sort(sortStr: String) {
        if (sortStr == "off") {
            musicList?.let { mAdapter.refreshData(it) }
            mMusicView.loadComplete()
        } else {
            val sortList = musicList!!.sortedBy { it.trackPrice }
                .sortedByDescending { it.artistName }
            mAdapter.refreshData(sortList)
            mMusicView.loadComplete()
        }


    }


}