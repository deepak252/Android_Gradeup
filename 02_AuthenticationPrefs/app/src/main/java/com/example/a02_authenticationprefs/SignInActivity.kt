package com.example.a02_authenticationprefs

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.google.android.material.textfield.TextInputLayout

class SignInActivity : AppCompatActivity() {
    lateinit var edtEmail: EditText
    lateinit var tilEmail : TextInputLayout
    lateinit var edtPwd: EditText
    lateinit var tilPwd : TextInputLayout

    private lateinit var prefs : SharedPreferences
    private lateinit var prefsEditor : SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        tilEmail = findViewById(R.id.tilEmail1)
        tilPwd = findViewById(R.id.tilPwd1)
        edtEmail = findViewById(R.id.edtEmail1)
        edtPwd = findViewById(R.id.edtPwd1)

        prefs = getSharedPreferences(resources.getString(R.string.prefs_file_key), Context.MODE_PRIVATE)
        prefsEditor = prefs.edit()


    }

    fun signIn(view : View){
        if(edtEmail.text.isEmpty()){
            tilEmail.error = "Enter Email"
            return
        }


        with(prefsEditor){
            putString("key_email",edtEmail.text?.toString())
            putString("key_password",edtPwd.text?.toString())
            apply()
        }


        val intent = Intent(this,HomeActivity::class.java)
        startActivity(intent)

    }

    override fun onResume() {
        super.onResume()
//        Toast.makeText(this,resources.getString(R.string.prefs_file_key),Toast.LENGTH_SHORT).show()
        val email = prefs.getString("key_email",null)
        val pwd = prefs.getString("key_password", null)

        edtEmail.setText(email)
        edtPwd.setText(pwd)

    }

}