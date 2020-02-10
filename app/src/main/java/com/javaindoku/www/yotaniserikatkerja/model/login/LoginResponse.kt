package com.javaindoku.www.yotaniserikatkerja.model.login

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LoginResponse(
    @SerializedName("id_karyawan") val access_token: String? = null,
    @SerializedName("token_type") val paraMeter: String? = null,
    @SerializedName("expires_in") val expires_in: String? = null,
    @SerializedName("as:client_id") val client_id: String? = null,
    @SerializedName("loginName") val loginName: String? = null,
    @SerializedName("fullName") val fullName: String? = null,
    @SerializedName("nik") val nik: String? = null,
    @SerializedName("employeeID") val employeeID: String? = null,
    @SerializedName("LocationID") val locationID: String? = null,
    @SerializedName("Location") val location: String? = null,
    @SerializedName("AttendancePrivilege") val attendancePrivilege: String? = null,
    @SerializedName(".issued") val issued: String? = null,
    @SerializedName(".expires") val expires: String? = null,
    var error_description: String = ""
) : Parcelable