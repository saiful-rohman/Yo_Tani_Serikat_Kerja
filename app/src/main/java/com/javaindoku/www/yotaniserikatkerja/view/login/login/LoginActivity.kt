package com.javaindoku.www.yotaniserikatkerja.view.login.login

import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import android.widget.Toast
import com.javaindoku.www.yotaniserikatkerja.R
import com.javaindoku.www.yotaniserikatkerja.view.homepage.HomeActivity
import com.javaindoku.www.yotaniserikatkerja.view.login.forgotpassword.ForgotPasswordActivity
import com.javaindoku.www.yotaniserikatkerja.view.login.register.RegisterActivity
import com.javaindoku.www.yotaniserikatkerja.utilities.SharedPref
import com.javaindoku.www.yotaniserikatkerja.viewmodel.login.LoginViewModel
import com.javaindoku.www.yotaniserikatkerja.model.login.LoginResponse
import kotlinx.android.synthetic.main.activity_login.*
import java.util.regex.Pattern

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var progressDialog: ProgressDialog
    private lateinit var mViewModel: LoginViewModel
    private val getLoginResponse = object : Observer<LoginResponse> {
        override fun onChanged(t: LoginResponse?) {
            if (t != null) {
                if (t.access_token != null) {
                    SharedPref.saveDataToken(this@LoginActivity, t)
                    Toast.makeText(this@LoginActivity, "login behasil", Toast.LENGTH_SHORT).show()
                    var intent = Intent(this@LoginActivity, HomeActivity::class.java)
                    progressDialog.dismiss()
                    startActivity(intent)
                } else {
                    progressDialog.dismiss()
                    Toast.makeText(this@LoginActivity, t.error_description, Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        bt_login_loginpage.setOnClickListener(this)
        tv_forgotpassword_loginpage.setOnClickListener(this)
        tv_register_loginpage.setOnClickListener(this)
        mViewModel = LoginViewModel()
        progressDialog = ProgressDialog(this)
        progressDialog.isIndeterminate = true
        progressDialog.setMessage("Otentikasi...")
        progressDialog.setCancelable(false)
        mViewModel.getLogin().observe(this, getLoginResponse)
    }

    override fun onClick(v: View?) {

        when (v?.id) {
            bt_login_loginpage.id -> {
                if (validasiLogin()) {
                    progressDialog.show()
                    mViewModel.doLogin(
                        user = et_username_loginpage.text.toString(),
                        passwod = et_password_loginpage.text.toString(),
                        grant = "password",
                        idClient = "ngAuthApp",
                        imei = "868042031440079"
                    )
                    /*
                    mViewModel.doLogin(
                      user = et_username_loginpage.text.toString(),
                        passwod = et_password_loginpage.text.toString(),
                        grant = "password",
                        idClient = "ngAuthApp",
                        imei = "868042031440079"
                    ).observe(this, getLoginResponse)
                    */
                }
            }
            tv_forgotpassword_loginpage.id -> {
                startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
            }
            tv_register_loginpage.id -> {
                startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            }
        }
    }

    private fun validasiLogin(): Boolean {
        if (et_username_loginpage.text.toString().isEmpty()) {
            et_username_loginpage.setError("Username dibutuhkan!")
            et_username_loginpage.requestFocus()
            return false
        }

        if (et_username_loginpage.text.toString().length < 4) {
            et_username_loginpage.setError("Username minimal 4 character!")
            et_username_loginpage.requestFocus()
            return false
        }
//        ^                 # start-of-string
//        (?=.*[0-9])       # a digit must occur at least once
//        (?=.*[a-z])       # a lower case letter must occur at least once
//        (?=.*[A-Z])       # an upper case letter must occur at least once
//        (?=.*[@#$%^&+=])  # a special character must occur at least once you can replace with your special characters
//        (?=\\S+$)         # no whitespace allowed in the entire string
//        .{4,}             # anything, at least six places though
//        $                 # end-of-string
        val pattern =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!#$%&'()*+,-./:;<=>?@\\[\\]^_`{|}~\"])(?=\\S+$).{5,}$")
        val match = pattern.matcher(et_password_loginpage.text.toString())
        if (!match.matches()) {
            et_password_loginpage.setError("Password minimal 4 character, contain digit, lower case, upper case, special character, and no contain white space!")
            et_password_loginpage.requestFocus()
            return false
        }
        return true
    }


}
