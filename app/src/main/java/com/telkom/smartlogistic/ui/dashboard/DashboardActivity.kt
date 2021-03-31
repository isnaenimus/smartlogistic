package com.telkom.smartlogistic.ui.dashboard

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.telkom.smartlogistic.R
import com.telkom.smartlogistic.base.BaseBottomNavigationActivity
import com.telkom.smartlogistic.databinding.ActivityDashboardBinding
import com.telkom.smartlogistic.framework.core.owner.ViewDataBindingOwner
import com.telkom.smartlogistic.framework.core.owner.ViewModelOwner
import com.telkom.smartlogistic.ui.onboarding.OnboardingActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

/**
 * Created by Isnaeni on 08/03/2021.
 */
class DashboardActivity : BaseBottomNavigationActivity(),
    DashboardView,
    ViewModelOwner<DashboardViewModel>,
    ViewDataBindingOwner<ActivityDashboardBinding> {

    override lateinit var binding: ActivityDashboardBinding
    override val viewModel: DashboardViewModel by viewModel()

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, DashboardActivity::class.java)
            context.startActivity(intent)
            (context as Activity).finish()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.bText.value = "Just try right?"
        binding.textDashboard.text = viewModel.bText.value

    }

    override fun getViewLayoutResId() = R.layout.activity_dashboard

    override fun getBottomNavigationMenuItemId(): Int {
        return R.id.navigation_dashboard
    }

    override fun onClick(view: View) {
        OnboardingActivity.startThisActivity(this)
        finish()
    }
}