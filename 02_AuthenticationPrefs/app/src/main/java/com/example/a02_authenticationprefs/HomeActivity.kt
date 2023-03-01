package com.example.a02_authenticationprefs

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class HomeActivity : AppCompatActivity() {
    private lateinit var prefs : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        prefs = getSharedPreferences(resources.getString(R.string.prefs_file_key), Context.MODE_PRIVATE)

        findViewById<TextView>(R.id.tvEmail2).text = "Welcome ${prefs.getString("key_email", null)}"

    }

    fun signOut(view : View){
        with(prefs.edit()){
            clear()
            apply()
        }
        finish()

    }
}