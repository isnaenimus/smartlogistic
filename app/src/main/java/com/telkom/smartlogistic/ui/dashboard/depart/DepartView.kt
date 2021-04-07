package com.telkom.smartlogistic.ui.dashboard.depart

import androidx.recyclerview.widget.LinearLayoutManager
import com.telkom.smartlogistic.framework.core.view.LifecycleView

/**
 * Created by Isnaeni on 01/04/2021.
 */
interface DepartView : LifecycleView {
    /*var listAdapter: ScheduleAdapter*/
    var layoutManager: LinearLayoutManager
}