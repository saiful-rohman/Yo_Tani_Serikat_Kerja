package com.javaindoku.www.yotaniserikatkerja.view.login.register

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.javaindoku.www.yotaniserikatkerja.R
import com.javaindoku.www.yotaniserikatkerja.view.login.login.LoginActivity
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        tv_login_registerpage.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        if (v?.id == tv_login_registerpage.id) {
            toLogin(this@RegisterActivity)
        }
    }

    private fun toLogin(activity: Activity) {
        val toLogin = Intent(activity, LoginActivity::class.java)
        startActivity(toLogin)
    }

}
