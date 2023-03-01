package com.example.demo

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class BFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("MyTag","Frag B: onAttach")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("MyTag","Frag B: onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_b, container, false)
    }

    override fun onStart() {
        super.onStart()
        Log.d("MyTag","Frag B: onStart")
    }

    override fun onResume() {
        super.onResume()
        Log.d("MyTag","Frag B: onResume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("MyTag","Frag B: onPause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("MyTag","Frag B: onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("MyTag","Frag B: onDestroy")
    }
}