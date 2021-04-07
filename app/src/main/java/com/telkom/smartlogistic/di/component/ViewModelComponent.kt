package com.telkom.smartlogistic.di.component

import com.telkom.smartlogistic.di.module.viewmodel.viewModelModule
import org.koin.core.module.Module

/**
 * Created by Isnaeni on 30/03/2021.
 */

val viewModelComponent: List<Module> = listOf(
    viewModelModule
)