package com.telkom.smartlogistic.di.component

import com.telkom.smartlogistic.di.module.network.apiNetworkModule
import org.koin.core.module.Module

/**
 * Created by Isnaeni on 30/03/2021.
 */
val networkComponent: List<Module> = listOf(
    apiNetworkModule
)