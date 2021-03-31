package com.telkom.smartlogistic.base

import android.content.Context
import androidx.multidex.MultiDex
import com.telkom.smartlogistic.di.component.networkComponent
import com.telkom.smartlogistic.di.component.viewModelComponent
import com.telkom.smartlogistic.framework.core.base.BaseMultidexApplication
import com.telkom.smartlogistic.framework.util.manager.PrefManager
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

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
        setupKoin()
    }

    private fun setupPreference() {
        PrefManager.init(this)
    }

    private fun setupKoin() {
        // start Koin context
        startKoin {
            androidContext(this@BaseApplication)
            androidLogger(Level.ERROR)
            modules(networkComponent)
            //modules(repositoryComponent)
            modules(viewModelComponent)
        }
    }
}