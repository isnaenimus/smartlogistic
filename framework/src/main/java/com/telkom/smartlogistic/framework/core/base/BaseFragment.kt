package com.telkom.smartlogistic.framework.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.telkom.framework.BR
import com.telkom.smartlogistic.framework.core.annotation.ViewLayout
import com.telkom.smartlogistic.framework.core.owner.ViewDataBindingOwner
import com.telkom.smartlogistic.framework.core.owner.ViewModelOwner
import com.telkom.smartlogistic.framework.core.view.BindingView

/**
 * Created by Isnaeni on 01/04/2021.
 */
abstract class BaseFragment : Fragment() {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return getLayoutIfDefined(inflater, container)
    }

    private fun getLayoutIfDefined(inflater: LayoutInflater, container: ViewGroup?): View? {
        val layoutResId = getViewLayoutResId()
        if (layoutResId == View.NO_ID) return null

        return if (this is ViewDataBindingOwner<*>) {
            val view = inflateContentViewBinding(inflater, container, layoutResId)
            if (this is ViewModelOwner<*>) {
                binding.setVariable(BR.vm, this.viewModel)
            }
            if (this is BindingView) {
                binding.setVariable(BR.view, this)
            }
            binding.lifecycleOwner = this
            view
        } else {
            inflater.inflate(layoutResId, container, false)
        }
    }

    protected open fun getViewLayoutResId(): Int {
        val layout = javaClass.annotations.find { it is ViewLayout } as? ViewLayout
        return layout?.value ?: View.NO_ID
    }
}