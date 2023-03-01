package com.example.mvvm_example

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface QuoteDao {
    @Insert
    suspend fun insertQuote(quote: Quote)
    @Update
    suspend fun updateQuote(quote: Quote)

    @Delete
    suspend fun deleteQuote(quote : Quote)

    @Query("SELECT * FROM quote")
    fun getQuotes() : LiveData<List<Quote>>
}