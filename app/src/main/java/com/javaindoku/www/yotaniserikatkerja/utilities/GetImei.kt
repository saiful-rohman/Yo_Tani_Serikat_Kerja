package com.javaindoku.www.yotaniserikatkerja.utilities

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.telephony.TelephonyManager
import androidx.core.content.ContextCompat
import java.lang.Exception

object GetImei {
    fun getDeviceImei(ctx: Context): String {
        try {
            val teleponearymanager =
                ctx.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
            var imei = ""
            if (ContextCompat.checkSelfPermission(
                    ctx,
                    android.Manifest.permission.READ_PHONE_STATE
                ) == PackageManager.PERMISSION_GRANTED
            ) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    imei = teleponearymanager.getImei()
                } else {
                    imei = teleponearymanager.deviceId
                }

                if (imei != null && !imei.isEmpty()) {
                    return imei
                } else {
                    return android.os.Build.SERIAL
                }


            } else {
                if (imei != null && !imei.isEmpty()) {
                    return imei
                } else {
                    return android.os.Build.SERIAL
                }
            }
        } catch (e: Exception) {
            return "not found"
        }
    }

}