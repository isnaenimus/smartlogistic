package com.telkom.smartlogistic.framework.core.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.telkom.smartlogistic.framework.core.annotation.ViewLayout
import com.telkom.smartlogistic.framework.core.owner.ViewDataBindingOwner
import com.telkom.smartlogistic.framework.core.owner.ViewModelOwner
import com.telkom.smartlogistic.framework.core.view.BindingView
import com.telkom.framework.BR


/**
 * Created by Isnaeni on 29/03/2021.
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        setLayoutIfDefined()
    }

    private fun setLayoutIfDefined() {
        val layoutResId = getViewLayoutResId()
        if (layoutResId == View.NO_ID) return

        if (this is ViewDataBindingOwner<*>) {
            setContentViewBinding(this, layoutResId)
            if (this is ViewModelOwner<*>) {
                binding.setVariable(BR.vm, this.viewModel)
            }
            if (this is BindingView) {
                binding.setVariable(BR.view, this)
            }
            binding.lifecycleOwner = this
        } else {
            setContentView(layoutResId)
        }
    }

    protected open fun getViewLayoutResId(): Int {
        val layout = javaClass.annotations.find { it is ViewLayout } as? ViewLayout
        return layout?.value ?: View.NO_ID
    }

}