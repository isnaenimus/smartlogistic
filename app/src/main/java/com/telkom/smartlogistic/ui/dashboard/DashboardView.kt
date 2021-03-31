package com.telkom.smartlogistic.ui.dashboard

import android.view.View
import com.telkom.smartlogistic.framework.core.view.LifecycleView

/**
 * Created by Isnaeni on 30/03/2021.
 */
interface DashboardView : LifecycleView {
    fun onClick(view: View)
}