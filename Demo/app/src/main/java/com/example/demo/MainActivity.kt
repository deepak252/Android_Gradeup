package com.example.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.FrameLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var btn1 : Button
    private lateinit var btn3 : Button
    private lateinit var btn4 : Button
    lateinit var frame : FrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        frame = findViewById(R.id.frame1)
        val fragmentA = AFragment()
        val fragmentB = BFragment()

        btn1 = findViewById(R.id.btn1)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)

        btn1.setOnClickListener{
            if(fragmentA.isAdded){
                return@setOnClickListener
            }
            if(!fragmentA.isAdded){
                supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.frame1,fragmentA)
                    .commit()
            }else{
//                Toast.makeText(this,"Fragment A", Toast.LENGTH_SHORT).show()
            }
        }

        btn3.setOnClickListener{
            if(fragmentB.isAdded){
                return@setOnClickListener
            }
            if(!fragmentB.isAdded){
                supportFragmentManager.beginTransaction()
                    .addToBackStack(null)
                    .replace(R.id.frame1,fragmentB)

                    .commit()

            }else{
//                Toast.makeText(this,"Fragment B already added", Toast.LENGTH_SHORT).show()
            }
        }
//
        btn4.setOnClickListener{
            val intent = Intent(this@MainActivity,MainActivity2::class.java)
            startActivity(intent)
        }

        Log.d("MyTag", "Activity1 onCreate")

    }

    override fun onStart() {
        super.onStart()
        Log.d("MyTag", "Activity1 onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MyTag", "Activity1 onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MyTag", "Activity1 onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MyTag", "Activity1 onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyTag", "Activity1 onDestroy")
    }
}