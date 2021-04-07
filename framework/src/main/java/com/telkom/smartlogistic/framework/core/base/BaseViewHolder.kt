package com.telkom.smartlogistic.framework.core.base

import android.content.Context
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.telkom.framework.BR
import com.telkom.smartlogistic.framework.core.owner.ViewDataBindingOwner
import com.telkom.smartlogistic.framework.core.owner.ViewModelOwner
import com.telkom.smartlogistic.framework.core.view.BindingViewHolder

/**
 * Created by Isnaeni on 01/04/2021.
 */
abstract class BaseViewHolder<T>(val context: Context, view: View) : RecyclerView.ViewHolder(view) {

    init {
        if (this is ViewDataBindingOwner<*>) {
            setViewBinding(view)
            if (this is ViewModelOwner<*>) {
                binding.setVariable(BR.vm, viewModel)
                binding.executePendingBindings()
            }
            if (this is BindingViewHolder<*>) {
                binding.setVariable(BR.view, this)
            }
        }
    }

    abstract fun bindData(data: T)
}