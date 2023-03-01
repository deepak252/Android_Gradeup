package com.example.retrofit_example

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getNews()

    }

    fun getNews(){
        val news = NewsService.INSTANCE.getNews()

        news.enqueue(object : Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                val news = response.body()
                Toast.makeText(this@MainActivity,news.toString(),Toast.LENGTH_SHORT).show()
//                Toast.makeText(this,news?.toString()?:"",Toast.LENGTH_SHORT).show()
                if(news!=null){
                    Log.d("MyTag",news.toString())
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("MyTag","Something went wrong!" )
            }

        })

    }
}

