package com.devaloteam.valorantmanager

import android.os.Bundle
import android.telecom.Call
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.devaloteam.valorantmanager.LogIn.Cookies.CookieVars
import com.google.android.material.textfield.TextInputEditText

class LogInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val username = findViewById<TextInputEditText>(R.id.Username)
        val password = findViewById<TextInputEditText>(R.id.PasswordInp)
        val btnLogin = findViewById<Button>(R.id.admin_go_btn)

        btnLogin.setOnClickListener {
            if(TextUtils.isEmpty(username.getText().toString()) || TextUtils.isEmpty(
                    password.getText().toString()
                )){
                Toast.makeText(this@LogInActivity, "Contraseña Mal", Toast.LENGTH_LONG).show()
            }else{
                //login
            }
        }
    }
    fun login() {

    }
}