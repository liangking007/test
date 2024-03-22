package com.example.myapplication.adapter

import androidx.databinding.ViewDataBinding
import com.example.myapplication.R
import com.example.myapplication.BR
import com.example.myapplication.base.BaseViewHolder
import com.example.myapplication.bean.MusicBase

class MusicAdapter : BaseAdapter<MusicBase>(){
    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        var binding : ViewDataBinding = holder.dataBinding
        binding.setVariable(BR.MusicBase,data.get(position))



    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_music
    }

}