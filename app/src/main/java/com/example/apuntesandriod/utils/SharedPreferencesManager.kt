package com.example.apuntesandriod.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.apuntesandriod.MyApp

object SharedPreferencesManager {
    private const val MyAppPreferencesName = "MySharedPreferences"
    private val shared: SharedPreferences by lazy {
        MyApp.Context.getSharedPreferences(MyAppPreferencesName,
            Context.MODE_PRIVATE
        )}

    private val editor: SharedPreferences.Editor by lazy {shared.edit()}

    private const val AppOpenTimesKey = "AppOpenTimes"


    public var TimesOpenApp :Int
        get() = shared.getInt(AppOpenTimesKey,0)
        set(newValue)  {
            editor.putInt(AppOpenTimesKey,newValue)
            editor.apply()
        }


}