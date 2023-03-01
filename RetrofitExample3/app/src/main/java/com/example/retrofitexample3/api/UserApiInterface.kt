package com.example.retrofitexample3.api

import com.example.retrofitexample3.models.UserListResponse
import com.example.retrofitexample3.models.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface UserApiInterface {
    @GET("/api/users/{id}")
    fun getUserById( @Path(value = "id") userId : Int) : Call<UserResponse>

    @GET("/api/users")
    fun getUsersList( @Query("page") page : Int) : Call<UserListResponse>
}


