package com.telkom.smartlogistic.ui.loginorsignup

import android.view.View
import com.telkom.smartlogistic.framework.core.view.LifecycleView

/**
 * Created by Isnaeni on 29/03/2021.
 */
interface LoginOrSignUpView : LifecycleView {
    fun onClickRegister(view: View)
    fun onClickLogin(view: View)
}