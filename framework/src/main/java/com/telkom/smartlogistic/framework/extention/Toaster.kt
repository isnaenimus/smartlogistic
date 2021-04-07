package com.telkom.smartlogistic.framework.extention

import android.content.Context
import android.widget.Toast
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment

/**
 * Created by Isnaeni on 29/03/2021.
 */
fun Fragment.showToast(@StringRes stringResource: Int) = context?.showToast(stringResource)

fun Fragment.showToast(message: String) = context?.showToast(message)

fun Context.showToast(@StringRes stringResource: Int) = showToast(getString(stringResource))

fun Context.showToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Fragment.showLongToast(@StringRes stringResource: Int) = context?.showLongToast(stringResource)

fun Fragment.showLongToast(message: String) = context?.showLongToast(message)

fun Context.showLongToast(@StringRes stringResource: Int) = showLongToast(getString(stringResource))

fun Context.showLongToast(message: String) = Toast.makeText(this, message, Toast.LENGTH_LONG).show()
