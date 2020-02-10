package com.javaindoku.www.yotaniserikatkerja.view.homepage

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.javaindoku.www.yotaniserikatkerja.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        button37.setOnClickListener(this)
    }


    override fun onClick(v: View?) {
        if (v?.id == button37.id) {

        }
    }
}
