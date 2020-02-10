package com.javaindoku.www.yotaniserikatkerja

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.javaindoku.www.yotaniserikatkerja.view.login.login.LoginActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startActivity(Intent(this@MainActivity,
            LoginActivity::class.java))

    }
}
