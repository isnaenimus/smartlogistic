package com.telkom.smartlogistic.ui.loginorsignup

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.View
import com.telkom.smartlogistic.R
import com.telkom.smartlogistic.databinding.ActivityLoginOrSignupBinding
import com.telkom.smartlogistic.framework.core.base.BaseActivity
import com.telkom.smartlogistic.framework.core.owner.ViewDataBindingOwner
import com.telkom.smartlogistic.ui.login.LoginActivity
import com.telkom.smartlogistic.ui.registration.RegistrationActivity

/**
 * Created by Isnaeni on 29/03/2021.
 */
class LoginOrSignUpActivity : BaseActivity(),
    LoginOrSignUpView,
    ViewDataBindingOwner<ActivityLoginOrSignupBinding> {

    companion object {
        fun startThisActivity(context: Context) {
            val intent = Intent(context, LoginOrSignUpActivity::class.java)
            context.startActivity(intent)
            (context as Activity).finish()
        }
    }

    override fun getViewLayoutResId() = R.layout.activity_login_or_signup
    override lateinit var binding: ActivityLoginOrSignupBinding

    override fun onClickRegister(view: View) {
        startActivity(Intent(applicationContext, RegistrationActivity::class.java))
    }

    override fun onClickLogin(view: View) {
        startActivity(Intent(applicationContext, LoginActivity::class.java))
    }
}