package com.javaindoku.www.yotaniserikatkerja.service

import com.javaindoku.www.yotaniserikatkerja.model.login.LoginResponse
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

interface Api {
    companion object {
        const val BASE_URL = "Https://xxxxxxxx/"
    }

    @FormUrlEncoded
    @POST("token")
    fun LoginApi(
        @Field("grant_type") grant_type: String,
        @Field("username") username: String,
        @Field("password") password: String,
        @Field("client_id") client_id: String,
        @Field("IMEI") imei: String
    ): Call<LoginResponse>

}