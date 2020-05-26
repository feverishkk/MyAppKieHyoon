package com.example.myappkiehyoon.Fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FragmentAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    // 화면에서 넘어가는 부분 First one, Second one, Third one 으로...
    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {
                FirstFragment()
            }
            1 -> {
                SecondFragment()
            }else -> {
                return ThirdFragment()
            }
        }
    }
    override fun getCount(): Int {
        return 3 // 넘어가는 숫자의 화면
    }
}
