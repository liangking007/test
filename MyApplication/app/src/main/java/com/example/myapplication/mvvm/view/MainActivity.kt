package com.example.myapplication.mvvm.view

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.ComponentActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.BR
import com.example.myapplication.R
import com.example.myapplication.adapter.MusicAdapter
import com.example.myapplication.base.IBaseView
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.mvvm.viewmode.MusicViewModel

class MainActivity : ComponentActivity(), IBaseView {

    var mMusicVM: MusicViewModel? = null
    var mAdapter: MusicAdapter? = null
    var mBinding: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        initView()
        mMusicVM = MusicViewModel(this, mAdapter!!)


        mBinding!!.editText.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {//输入后的监听

            }

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {//输入后的监听

            }

            override fun onTextChanged(
                s: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {//输入文字产生变化的监听
                mMusicVM!!.search(s.toString())
            }
        })


        mBinding!!.off.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // RadioButton1被选中时的操作
                mBinding!!.sort.isChecked = false
                mMusicVM!!.sort("off")
            }
        }

        mBinding!!.sort.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                // RadioButton2被选中时的操作
                mBinding!!.off.isChecked = false
                mMusicVM!!.sort("sort")
            }
        }


    }


    fun initView() {
        val layoutManager = LinearLayoutManager(this)
        mBinding!!.recyclerview.layoutManager = layoutManager
        mAdapter = MusicAdapter()
        mBinding!!.recyclerview.adapter = mAdapter
    }

    override fun loadComplete() {

    }

    override fun loadFailure(error: String) {

    }


   ///////////////////////////////////////////////////////////////////////////////////////
    /*
        *Sectionl-Brain Teasers (10%)
        *Given an array of meeting time intervals consisting of start and end times[[s1,e1],[s2,e2],...](si < ei), please provide a function with implementation by Swift/Kotlinto determine if a person could attend all meetings.
        *For example,
        *Input: intervals=[[0,30],[5,10],[15,20]l Output: falseExplanation: The person can only attend some meetings because there is an overlap between[0,30]and [5,10],and between [o,30]and [15,20].
        *Input: intervals =[[7,10],[2,4]]Output: trueExplanation: The person can attend all meetings because there is no overlap between [7, 10and [2,4].
        *Input: intervals=[[1,5l,[8,9l,[8,10]1Output: falseExplanation: The person can only attend some meetings because there is an overlap between[8,9] and [8,10].
    **/


    var meetingTime1: List<List<Int>> = listOf(
        listOf(5, 10), listOf(15, 20), listOf(
            0,
            30
        )
    )
    var meetingTime2: List<List<Int>> = listOf(listOf(7, 10), listOf(2, 4))
    var meetingTime3: List<List<Int>> = listOf(
        listOf(1, 5), listOf(8, 10), listOf(
            8,
            9
        )
    )

    fun canAttendMeetings(meetingTime: List<List<Int>>): Boolean {
        //按照开始时间对会议进行排序（即小到大排序）
        var tempMeetingTime = meetingTime.sortedBy { it.first() }
        //遍历会议,检查每个会议结束时间是否在下个会议的开始时间之内
        for (i in tempMeetingTime.indices) {
            if (i < tempMeetingTime.size - 1) {
                if (tempMeetingTime[i][1] > tempMeetingTime[i + 1][0]) {
                    return false
                }
            }
        }
        return true
    }
   ///////////////////////////////////////////////////////////////////////////////////////

}





































