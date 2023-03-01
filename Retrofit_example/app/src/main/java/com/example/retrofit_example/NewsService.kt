package com.example.retrofit_example

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//https://fakestoreapi.com/products

const val NEWS_URL = "https://saurav.tech/NewsAPI/"

interface NewsInterface {

    @GET("top-headlines/category/health/in.json")
    fun getNews() : Call<News>

}


object NewsService{
    lateinit var INSTANCE : NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(NEWS_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        INSTANCE = retrofit.create(NewsInterface::class.java)
    }
}
