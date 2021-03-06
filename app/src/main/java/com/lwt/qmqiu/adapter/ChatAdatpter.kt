package com.lwt.qmqiu.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class ChatAdatpter(fm:FragmentManager, list: ArrayList<Fragment>, titles : MutableList<String>) : FragmentPagerAdapter(fm) {
    var mFm : androidx.fragment.app.FragmentManager = fm
    var mList : ArrayList<androidx.fragment.app.Fragment> = list
    var mTitles : MutableList<String> = titles
    override fun getItem(position: Int): androidx.fragment.app.Fragment {
        return mList[position]

    }
    override fun getCount(): Int {
        return mList.size
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mTitles[position]
    }


}