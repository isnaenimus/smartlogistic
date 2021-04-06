package com.telkom.smartlogistic.framework.core.view

import android.view.View

/**
 * Created by Isnaeni on 01/04/2021.
 */
interface BindingViewHolder<in T> : BindingView {

    fun onItemClick(view: View, item: T)
}