package com.example.myapplication.data

import com.example.myapplication.R
import com.example.myapplication.models.Product

class Products {
    companion object{
//        var allProducts = ArrayList<Product>()
        var allProducts = arrayListOf<Product>(
            Product(1,"T-Shirt","Fashion",200,R.drawable.img1),
            Product(2,"T-Shirt-2","Fashion",300,R.drawable.img2),
            Product(3,"T-Shirt","Fashion",400,R.drawable.img3),
            Product(4,"T-Shirt","Fashion",250,R.drawable.img4)
        )

    }
//    init {
//        allProducts.add(Product(1,"T-Shirt","Fashion",200))
//        allProducts.add(Product(2,"T-Shirt-2","Fashion",300))
//        allProducts.add(Product(3,"T-Shirt","Fashion",400))
//        allProducts.add(Product(4,"T-Shirt","Fashion",250))
//    }
}