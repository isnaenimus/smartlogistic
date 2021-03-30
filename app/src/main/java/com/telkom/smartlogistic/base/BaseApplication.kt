package com.telkom.smartlogistic.base

import android.content.Context
import androidx.multidex.MultiDex
import com.telkom.smartlogistic.framework.core.base.BaseMultidexApplication
import com.telkom.smartlogistic.framework.util.manager.PrefManager

/**
 * Created by Isnaeni on 08/03/2021.
 */
class BaseApplication : BaseMultidexApplication() {

    companion object {
        var appContext: Context? = null
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun onCreate() {
        super.onCreate()
        appContext = this

        setupPreference()
    }

    private fun setupPreference() {
        PrefManager.init(this)
    }
}