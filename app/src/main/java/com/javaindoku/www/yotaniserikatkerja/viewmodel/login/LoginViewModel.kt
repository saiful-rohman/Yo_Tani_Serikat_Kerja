package com.javaindoku.www.yotaniserikatkerja.viewmodel.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.javaindoku.www.yotaniserikatkerja.service.RetrofitClient
import com.javaindoku.www.yotaniserikatkerja.model.login.LoginResponse
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginViewModel : ViewModel() {

    private val login = MutableLiveData<LoginResponse>()

    fun getLogin(): LiveData<LoginResponse> {
        return this.login
    }


    fun doLogin(
        user: String,
        passwod: String,
        grant: String,
        idClient: String,
        imei: String
    )
    //: LiveData<LoginResponse> 
    {

        //       val loginResponse = MutableLiveData<LoginResponse>()

        RetrofitClient.instance.LoginApi(
            username = user,
            password = passwod,
            grant_type = grant,
            imei = imei,
            client_id = idClient

        ).enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                val returnFailureResponse =
                    LoginResponse()
                returnFailureResponse.error_description = "Failed connect to Internet"
                login.postValue(returnFailureResponse)
            }

            override fun onResponse(
                call: Call<LoginResponse>,
                response: Response<LoginResponse>
            ) {
                if (response.code() == 200) {
                    if (response.body() != null) {
                        login.postValue(response.body())
                    }
                } else {
                    val returnResponse =
                        LoginResponse()
                    try {
                        response.errorBody()?.let {
                            val json = JSONObject(it.string())
                            returnResponse.error_description = json.optString("error_description")
                        }
                        login.postValue(returnResponse)
                    } catch (e: Exception) {
                        e.message?.let {
                            returnResponse.error_description = it
                        }
                    }
                    login.postValue(returnResponse)
                    // loginResponse.postValue(LoginResponse())
                }
            }

        })
        //  return loginResponse
    }

}