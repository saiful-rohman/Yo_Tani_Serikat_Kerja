package com.javaindoku.www.yotaniserikatkerja.utilities

import android.content.Context
import com.javaindoku.www.yotaniserikatkerja.model.login.LoginResponse

object SharedPref {
    private val SHARED_PREF_NAME = "data_shared_preff"

    fun saveDataToken(
        context: Context,
        data: LoginResponse
    ) {
        val pref = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE).edit()
        pref.putString("name", data.fullName)
        pref.putString("idEmp", data.employeeID)
        pref.putString("loc", data.location)
        pref.putString("nik", data.nik)
        pref.apply()
    }

    fun clear(
        context: Context
    ) {
        val pref = context.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE).edit()
        pref.clear()
        pref.apply()
    }
}