package com.example.demo

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast


class AFragment : Fragment() {

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("MyTag","Frag A: onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MyTag","Frag A: onCreate")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d("MyTag","Frag A: onCreateView")
//        Toast.makeText(this,"Fragment A", Toast.LENGTH_SHORT).show()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false)
    }

    override fun onStart() {
        super.onStart()
        Log.d("MyTag","Frag A: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MyTag","Frag A: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MyTag","Frag A: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MyTag","Frag A: onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyTag","Frag A: onDestroy")
    }


}