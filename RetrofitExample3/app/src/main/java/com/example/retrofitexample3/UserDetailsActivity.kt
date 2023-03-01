package com.example.retrofitexample3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.retrofitexample3.models.UserData
import com.example.retrofitexample3.models.UserListResponse
import com.example.retrofitexample3.models.UserResponse
import com.example.retrofitexample3.services.RetrofitService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserDetailsActivity : AppCompatActivity() {
    lateinit var loader : ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        loader = findViewById(R.id.loader2)
        val userId = intent.getIntExtra("userId",1)
        fetchUserById(userId)

    }

    fun fetchUserById(id : Int){
        loader.visibility = View.VISIBLE
        val users = RetrofitService.INSTANCE.getUserById(id).enqueue(
            object : Callback<UserResponse> {
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    val user = response.body()?.data
                    loader.visibility = View.GONE
                    Log.d("MyTag", response.body().toString())
                    if(user!=null){
                        Glide.with(this@UserDetailsActivity)
                            .load(user.avatar)
                            .placeholder(R.drawable.baseline_person_24)
                            .into(findViewById<ImageView>(R.id.imgU2))
                        findViewById<TextView>(R.id.tvName2).text = "${user.firstName} ${user.lastName}"
                        findViewById<TextView>(R.id.tvEmail2).text = "${user.email}"

                    }

                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    loader.visibility = View.GONE
                    Toast.makeText(this@UserDetailsActivity,"${t.message}", Toast.LENGTH_SHORT).show()
                }

            }
        )
    }
}