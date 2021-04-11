package com.telkom.smartlogistic.ui.order

import android.view.View
import com.telkom.smartlogistic.framework.core.view.LifecycleView

interface OrderView : LifecycleView {
    fun onClick(view: View)
}