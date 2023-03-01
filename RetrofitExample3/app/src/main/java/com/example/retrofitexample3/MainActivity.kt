package com.example.retrofitexample3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitexample3.adapters.UsersAdapter
import com.example.retrofitexample3.models.UserData
import com.example.retrofitexample3.models.UserListResponse
import com.example.retrofitexample3.services.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var rvUsers : RecyclerView
    lateinit var loader : ProgressBar
    var usersList = mutableListOf<UserData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvUsers = findViewById(R.id.rvUsers)
        loader = findViewById(R.id.loader1)
        rvUsers.apply {
            adapter = UsersAdapter(usersList,this@MainActivity)
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
        fetchUsersList()
    }

    fun fetchUsersList(){
        loader.visibility = View.VISIBLE
        val users = RetrofitService.INSTANCE.getUsersList(1).enqueue(
            object : Callback<UserListResponse>{
                override fun onResponse(
                    call: Call<UserListResponse>,
                    response: Response<UserListResponse>
                ) {
                    loader.visibility = View.GONE
                    Log.d("MyTag", response.body().toString())
                    usersList.addAll(response.body()!!.data)
                    rvUsers.adapter?.notifyDataSetChanged()
                }

                override fun onFailure(call: Call<UserListResponse>, t: Throwable) {
                    loader.visibility = View.GONE
                    Toast.makeText(this@MainActivity,"${t.message}", Toast.LENGTH_SHORT).show()
                }

            }
        )
    }
}