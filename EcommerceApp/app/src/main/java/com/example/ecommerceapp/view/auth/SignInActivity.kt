package com.example.ecommerceapp.view.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.ecommerceapp.MainActivity
import com.example.ecommerceapp.R

class SignInActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
    }

    fun navigateToSignUp(view : View){
        val intent = Intent(this, SignUpActivity::class.java)
        startActivity(intent)
    }

    fun navigateToDashboard(view : View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}