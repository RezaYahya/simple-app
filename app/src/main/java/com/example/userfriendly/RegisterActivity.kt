package com.example.userfriendly

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        etUsername = findViewById(R.id.edt_username)
        etPassword = findViewById(R.id.edt_password)

        val btnRegister: Button = findViewById(R.id.btn_register)
        btnRegister.setOnClickListener{
            val bundle = Bundle()
            bundle.putString("Username", etUsername.text.toString())
            bundle.putString("Password", etPassword.text.toString())

            val intent = Intent (this@RegisterActivity, LoginActivity::class.java)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}