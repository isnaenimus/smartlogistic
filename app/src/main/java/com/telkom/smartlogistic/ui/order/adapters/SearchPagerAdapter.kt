package com.telkom.smartlogistic.ui.order.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.telkom.smartlogistic.framework.core.base.BaseFragment

class SearchPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val mFragmentList = ArrayList<BaseFragment>()
    private val mFragmentTitleList = ArrayList<String>()

    fun addFragment(fragment: BaseFragment, title: String) {
        mFragmentList.add(fragment)
        mFragmentTitleList.add(title)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitleList[position].substring(0, 1).toUpperCase() + mFragmentTitleList[position].substring(1).toLowerCase()
    }

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }
}