package com.telkom.smartlogistic.framework.core.owner

import com.telkom.smartlogistic.framework.core.base.BaseViewModel

/**
 * Created by Isnaeni on 29/03/2021.
 */
interface ViewModelOwner<T : BaseViewModel> {
    val viewModel: T
}