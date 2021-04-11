package com.telkom.smartlogistic.ui.order.fragments

import com.telkom.smartlogistic.R
import com.telkom.smartlogistic.databinding.FragmentSavedSearchBinding
import com.telkom.smartlogistic.framework.core.base.BaseFragment
import com.telkom.smartlogistic.framework.core.owner.ViewDataBindingOwner

class SavedSearchFragment() :
        BaseFragment(),
        ViewDataBindingOwner<FragmentSavedSearchBinding> {
    override fun getViewLayoutResId() = R.layout.fragment_saved_search
    override lateinit var binding: FragmentSavedSearchBinding
}