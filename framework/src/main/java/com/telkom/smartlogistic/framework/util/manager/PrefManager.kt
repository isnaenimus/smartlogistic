package com.telkom.smartlogistic.framework.util.manager

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Isnaeni on 08/03/2021.
 */
object PrefManager {

    private const val NAME = "PreferenceLogistic"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    private val onboarding = Pair("onboarding", true)

    fun init(context: Context) {
        preferences = context.getSharedPreferences(
                NAME,
                MODE
        )
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var ONBOARDING: Boolean
        get() = preferences.getBoolean(
                onboarding.first, onboarding.second
        )
        set(value) = preferences.edit {
            it.putBoolean(onboarding.first, value)
        }
}