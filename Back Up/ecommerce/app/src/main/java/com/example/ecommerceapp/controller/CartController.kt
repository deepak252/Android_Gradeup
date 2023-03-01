package com.example.ecommerceapp.controller

import com.example.ecommerceapp.model.CartItem

object CartController {
    private val cartItems = arrayListOf(
        CartItem(1,ProductController.getProducts()[0])
    )

    fun getCartItems() : ArrayList<CartItem>{
        return cartItems
    }

    fun addItem(item: CartItem){
        cartItems.add(item)
    }
    /**
     *  Returns index of removed item
     **/
    fun removeItem(productId : Int) : Int{
        val i = cartItems.indexOfFirst {
            it.product.id == productId
        }
        if(i!=-1){
            cartItems.removeAt(i)
        }
        return i
    }




}