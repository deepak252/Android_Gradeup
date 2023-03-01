package com.example.myapplication.data

import com.example.myapplication.models.CartItem
import com.example.myapplication.models.Product

class Cart {
    companion object{
        val items = arrayListOf<CartItem>(
        )
        fun itemsCount(): Int{
            return items.size
        }
    }
}