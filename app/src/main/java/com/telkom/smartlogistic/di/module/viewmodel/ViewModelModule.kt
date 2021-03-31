package com.telkom.smartlogistic.di.module.viewmodel

import com.telkom.smartlogistic.ui.dashboard.DashboardViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by Isnaeni on 30/03/2021.
 */

val viewModelModule = module {

    viewModel { DashboardViewModel() }
}