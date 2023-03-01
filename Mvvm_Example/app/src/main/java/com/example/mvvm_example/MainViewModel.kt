package com.example.mvvm_example

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class MainViewModel( val repository: QuoteRepository) : ViewModel() {

    fun getQuotes() : LiveData<List<Quote>>{
        return repository.getQuotes()
    }

    fun insertQuote(quote : Quote){

    }




}