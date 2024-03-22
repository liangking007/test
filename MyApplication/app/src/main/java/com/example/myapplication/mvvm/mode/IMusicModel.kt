package com.example.myapplication.mvvm.mode

import com.example.myapplication.base.BaseLoadListener
import com.example.myapplication.bean.MusicBase

interface IMusicModel{
    fun loadMusicList(loadListener: BaseLoadListener<List<MusicBase>>)
}