package com.javaindoku.www.yotaniserikatkerja.app

import android.app.Application
import android.content.Context
import com.javaindoku.www.yotaniserikatkerja.utilities.PrefHelper
import com.javaindoku.www.yotaniserikatkerja.utilities.SharedPrefKeys
import com.yariksoffice.lingver.Lingver
import com.yariksoffice.lingver.store.PreferenceLocaleStore
import java.util.*

class YoTaniApplicationSerikat : Application() {

    companion object {
        const val LANGUAGE_ENGLISH = "en"
        const val LANGUAGE_INDONESIAN = "in"
    }

    @Suppress("UNUSED_VARIABLE")
    override fun onCreate() {
        super.onCreate()
        val store = PreferenceLocaleStore(this, Locale(LANGUAGE_ENGLISH))
        // you can use this instance for DI or get it via Lingver.getInstance() later on
        val lingver = Lingver.init(this, store)
        Lingver.getInstance().setLocale(this, LANGUAGE_INDONESIAN)
        PrefHelper.setSharedPreferences(applicationContext, SharedPrefKeys.sharedName,
            Context.MODE_PRIVATE)

    }

}