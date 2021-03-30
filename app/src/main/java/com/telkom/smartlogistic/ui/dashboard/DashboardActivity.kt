package com.telkom.smartlogistic.ui.dashboard

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.telkom.smartlogistic.R
import com.telkom.smartlogistic.base.BaseBottomNavigationActivity

/**
 * Created by Isnaeni on 08/03/2021.
 */
class DashboardActivity : BaseBottomNavigationActivity() {
    private var dashboardViewModel: DashboardViewModel? = null
    var textView: TextView? = null

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, DashboardActivity::class.java)
            context.startActivity(intent)
            (context as Activity).finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dashboardViewModel = ViewModelProvider(this).get(DashboardViewModel::class.java)
        dashboardViewModel!!.text.observe(this, Observer { text: String? -> textView!!.text = text })
        setVariable()
    }

    private fun setVariable() {
        textView = findViewById(R.id.text_dashboard)
    }

    override fun getContentViewId(): Int {
        return R.layout.activity_dashboard
    }

    override fun getBottomNavigationMenuItemId(): Int {
        return R.id.navigation_dashboard
    }
}