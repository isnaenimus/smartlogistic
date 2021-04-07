package com.telkom.smartlogistic.ui.dashboard.depart

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.telkom.smartlogistic.R
import com.telkom.smartlogistic.databinding.FragmentDepartBinding
import com.telkom.smartlogistic.framework.core.base.BaseFragment
import com.telkom.smartlogistic.framework.core.owner.ViewDataBindingOwner

/**
 * Created by Isnaeni on 01/04/2021.
 */
class DepartFragment() : BaseFragment(),
    //DepartView,
    ViewDataBindingOwner<FragmentDepartBinding> {

    override fun getViewLayoutResId() = R.layout.fragment_depart

    override lateinit var binding: FragmentDepartBinding

    /*override var layoutManager = LinearLayoutManager(
            activity,
            RecyclerView.VERTICAL,
            false
    )*/

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    fun setData() {

    }
}