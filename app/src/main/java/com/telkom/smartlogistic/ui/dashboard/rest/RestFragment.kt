package com.telkom.smartlogistic.ui.dashboard.rest

import android.os.Bundle
import android.view.View
import com.telkom.smartlogistic.R
import com.telkom.smartlogistic.databinding.FragmentRestBinding
import com.telkom.smartlogistic.framework.core.base.BaseFragment
import com.telkom.smartlogistic.framework.core.owner.ViewDataBindingOwner

/**
 * Created by Isnaeni on 01/04/2021.
 */
class RestFragment() : BaseFragment(),
    RestView,
    ViewDataBindingOwner<FragmentRestBinding> {

    override fun getViewLayoutResId() = R.layout.fragment_rest

    override lateinit var binding: FragmentRestBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setData()
    }

    fun setData() {

    }
}