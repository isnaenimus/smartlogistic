package com.telkom.smartlogistic.ui.order.fragments

import android.os.Bundle
import android.view.View
import com.telkom.smartlogistic.R
import com.telkom.smartlogistic.databinding.FragmentNewSearchBinding
import com.telkom.smartlogistic.framework.core.base.BaseFragment
import com.telkom.smartlogistic.framework.core.owner.ViewDataBindingOwner

class NewSearchFragment() :
        BaseFragment(),
        ViewDataBindingOwner<FragmentNewSearchBinding> {
    override fun getViewLayoutResId() = R.layout.fragment_new_search
    override lateinit var binding: FragmentNewSearchBinding
}