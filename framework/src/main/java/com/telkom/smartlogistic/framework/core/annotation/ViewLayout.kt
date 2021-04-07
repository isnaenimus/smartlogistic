package com.telkom.smartlogistic.framework.core.annotation

import android.view.View
import androidx.annotation.LayoutRes
import androidx.annotation.NonNull

/**
 * Created by Isnaeni on 29/03/2021.
 */
@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class ViewLayout(@LayoutRes @NonNull val value: Int = View.NO_ID)
