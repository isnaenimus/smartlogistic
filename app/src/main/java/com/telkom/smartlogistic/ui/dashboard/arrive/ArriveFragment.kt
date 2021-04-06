package com.telkom.smartlogistic.ui.dashboard.arrive

import android.os.Bundle
import android.view.View
import com.telkom.smartlogistic.R
import com.telkom.smartlogistic.databinding.FragmentArriveBinding
import com.telkom.smartlogistic.framework.core.base.BaseFragment
import com.telkom.smartlogistic.framework.core.owner.ViewDataBindingOwner
import com.telkom.smartlogistic.ui.dashboard.depart.DepartView

/**
 * Created by Isnaeni on 01/04/2021.
 */
class ArriveFragment() : BaseFragment(),
    ArriveView,
    ViewDataBindingOwner<FragmentArriveBinding> {

    override fun getViewLayoutResId() = R.layout.fragment_arrive

    override lateinit var binding: FragmentArriveBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    fun setData() {

    }
}