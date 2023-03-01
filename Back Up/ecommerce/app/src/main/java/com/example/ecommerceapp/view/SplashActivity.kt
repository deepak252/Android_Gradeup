package com.example.ecommerceapp.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.ecommerceapp.MainActivity
import com.example.ecommerceapp.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)


        Handler(Looper.getMainLooper()).postDelayed(Runnable {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        },1000)

//        var runnable = object : Runnable{
//            override fun run() {
//                Thread.sleep(2000)
//                val intent = Intent(this@SplashActivity, MainActivity::class.java)
//                startActivity(intent)
//                finish()
//            }
//        }
//        Thread(runnable).start()





    }
}