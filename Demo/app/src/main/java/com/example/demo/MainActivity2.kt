package com.example.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity() {
    lateinit var btn2 : Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        Log.d("MyTag", "Activity2 onCreate")

        btn2 = findViewById(R.id.btn2)

        btn2.setOnClickListener{
            AlertDialog.Builder(this)
                .setTitle("Hii !")
                .show()

        }
    }

    override fun onStart() {
        super.onStart()
        Log.d("MyTag", "Activity2 onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MyTag", "Activity2 onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MyTag", "Activity2 onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MyTag", "Activity2 onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyTag", "Activity2 onDestroy")
    }
}