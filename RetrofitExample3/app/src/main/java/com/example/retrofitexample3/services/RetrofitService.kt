package com.example.retrofitexample3.services

import com.example.retrofitexample3.api.UserApiInterface
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val BASE_URL = "https://reqres.in/"

object RetrofitService{
    val INSTANCE : UserApiInterface

    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        INSTANCE = retrofit.create(UserApiInterface::class.java)
    }
}

//class RetrofitService<T>{
//    companion object{
//        @Volatile
//        private var INSTANCE : UserApiInterface?=null
//        fun <T>getInstance(){
//            if(INSTANCE==null){
//                var retrofit = Retrofit.Builder()
//                    .baseUrl(BASE_URL)
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .build()
//            }
//        }
//    }
//}