package com.example.ecommerce_mvvm.controller

import com.example.ecommerce_mvvm.model.Product

object ProductController {

    private val products = arrayListOf(
        Product(1,109.9,"Foldsack No. 1 Backpack","Men's clothing","Your perfect pack for everyday use and walks in the forest.","https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"),
        Product(2,55.0,"Mens Cotton Jacket","Men's clothing","Good gift choice for you or your family member.","https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg"),
        Product(3,101.1,"Casual Premium Slim Fit T-Shirts","Men's clothing","Slim-fitting style, contrast raglan long sleeve","https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg"),
        Product(4,109.9,"Foldsack No. 1 Backpack","Men's clothing","Your perfect pack for everyday use and walks in the forest.","https://fakestoreapi.com/img/81fPKd-2AYL._AC_SL1500_.jpg"),
        Product(5,55.0,"Mens Cotton Jacket","Men's clothing","Good gift choice for you or your family member.","https://fakestoreapi.com/img/71li-ujtlUL._AC_UX679_.jpg"),
        Product(6,101.1,"Casual Premium Slim Fit T-Shirts","Men's clothing","Slim-fitting style, contrast raglan long sleeve","https://fakestoreapi.com/img/71-3HjGNDUL._AC_SY879._SX._UX._SY._UY_.jpg"),
    )

    fun getProducts() : ArrayList<Product>{
        return products
    }

    fun addProduct(product: Product) {
        products.add(product)
    }


}