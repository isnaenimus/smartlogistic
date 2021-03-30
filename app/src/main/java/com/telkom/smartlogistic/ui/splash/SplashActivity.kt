package com.telkom.smartlogistic.ui.splash

import com.telkom.smartlogistic.R
import android.os.Bundle
import android.os.Handler
import com.telkom.smartlogistic.framework.core.base.BaseActivity
import com.telkom.smartlogistic.ui.onboarding.OnboardingActivity


/**
 * Created by Isnaeni on 29/03/2021.
 */
class SplashActivity : BaseActivity() {

    override fun getViewLayoutResId() = R.layout.activity_splash

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val handler = Handler()
        handler.postDelayed(
                {
                   OnboardingActivity.startThisActivity(this)
                    finish()
                },
                3000
        )
    }
}