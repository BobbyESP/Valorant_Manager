package com.devaloteam.valorantmanager

import android.os.Bundle
import android.telecom.Call
import android.text.TextUtils
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.devaloteam.valorantmanager.LoginTest.MainViewModel
import com.devaloteam.valorantmanager.LoginTest.MainViewModelFactory
import com.devaloteam.valorantmanager.LoginTest.model.Post
import com.devaloteam.valorantmanager.LoginTest.repository.Repository
import com.google.android.material.textfield.TextInputEditText

class LogInActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private val myAdapter by lazy { MyAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_log_in)

        val repository = Repository()
        val viewModelFactory = MainViewModelFactory(repository)
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
                viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
                val myPost = Post()
                viewModel.pushPost()

            }
        }
    }
}