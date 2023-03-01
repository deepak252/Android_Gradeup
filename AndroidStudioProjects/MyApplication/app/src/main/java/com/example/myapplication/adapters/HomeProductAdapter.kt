package com.example.myapplication.adapters

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.Cart
import com.example.myapplication.data.Products
import com.example.myapplication.models.CartItem
import com.example.myapplication.models.Product
import com.example.myapplication.ui.MyCartActivity
import com.example.myapplication.ui.ProductDetailsActivity
import com.google.android.material.snackbar.Snackbar

class HomeProductAdapter (private val products : ArrayList<Product>, private val context : Context) : RecyclerView.Adapter<HomeProductAdapter.HomeProductViewHolder>() {
    var homeScreenListener : HomeScreenListener?=null

    inner class HomeProductViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val tvProductName =  view.findViewById<TextView>(R.id.tvNameProductHome)!!
        val tvProductCategory =  view.findViewById<TextView>(R.id.tvCategoryProductHome)!!
        val tvProductPrice =  view.findViewById<TextView>(R.id.tvPriceProductHome)!!
        val btnAddCart = view.findViewById<Button>(R.id.btnAddCart)!!
        var imgProduct = view.findViewById<ImageView>(R.id.imgProductHome)

        init {
            homeScreenListener = context as HomeScreenListener
        }

        fun updateView(index : Int){
            if(isProductInCart(Products.allProducts[index])){
                btnAddCart.text="Go To Cart"

            }else{
                btnAddCart.text = "Add"
            }
            homeScreenListener?.updateCartCount()
        }

    }

    interface HomeScreenListener{
        fun updateCartCount()

    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeProductViewHolder {
        val view  = LayoutInflater.from(context).inflate(R.layout.home_product_view, parent, false)
        return HomeProductViewHolder(view)
    }

    override fun getItemCount(): Int {
        return products.size
    }

    override fun onBindViewHolder(holder: HomeProductViewHolder, position: Int) {
        var product = products[position]
        holder.tvProductName.text = product.name
        holder.tvProductPrice.text = "$ ${product.price}"
        holder.tvProductCategory.text = product.category
        holder.imgProduct.setImageResource(product.img)
        holder.updateView(position)
        holder.btnAddCart.setOnClickListener{
            if(!isProductInCart(product)){
                //Add Product To Cart
                Cart.items.add(
                    CartItem(product,1)
                )
                Toast.makeText(context,"Product added to cart", Toast.LENGTH_SHORT).show()
                holder.updateView(position)
            }else{
                // Navigate to Cart Page
                val intent = Intent(context, MyCartActivity::class.java)
                context.startActivity(intent)
            }
        }

        holder.itemView.setOnClickListener{
            val intent = Intent(context,ProductDetailsActivity::class.java)
            intent.putExtra("productKey", product)
            context.startActivity(intent)
        }

    }

    fun isProductInCart(product : Product) : Boolean{
        return Cart.items.indexOfFirst {
            it.product.id == product.id

        }!=-1
    }


}


//package com.example.myapplication.adapters
//
//import android.content.Context
//import android.content.Intent
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.Button
//import android.widget.TextView
//import android.widget.Toast
//import androidx.constraintlayout.widget.ConstraintLayout
//import androidx.recyclerview.widget.RecyclerView
//import com.example.myapplication.R
//import com.example.myapplication.data.Cart
//import com.example.myapplication.data.Products
//import com.example.myapplication.models.CartItem
//import com.example.myapplication.models.Product
//import com.example.myapplication.ui.MyCartActivity
//import com.example.myapplication.ui.ProductDetailsActivity
//import com.google.android.material.snackbar.Snackbar
//
//class HomeProductAdapter (private val products : ArrayList<Product>, private val context : Context) : RecyclerView.Adapter<HomeProductAdapter.HomeProductViewHolder>() {
//    var homeScreenListener : HomeScreenListener?=null
//
//    inner class HomeProductViewHolder(view : View) : RecyclerView.ViewHolder(view){
//        val tvProductName =  view.findViewById<TextView>(R.id.tvNameProductHome)!!
//        val tvProductCategory =  view.findViewById<TextView>(R.id.tvCategoryProductHome)!!
//        val tvProductPrice =  view.findViewById<TextView>(R.id.tvPriceProductHome)!!
//        val btnAddCart = view.findViewById<Button>(R.id.btnAddCart)!!
//
//        init {
//            homeScreenListener = context as HomeScreenListener
//        }
//
//        fun updateView(index : Int){
//            if(isProductInCart(Products.allProducts[index])){
//                btnAddCart.text="Go To Cart"
//
//            }else{
//                btnAddCart.text = "Add"
//            }
//            homeScreenListener?.updateCartCount()
//        }
//
//    }
//
//    interface HomeScreenListener{
//        fun updateCartCount()
//    }
//
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeProductViewHolder {
//        val view  = LayoutInflater.from(context).inflate(R.layout.home_product_view, parent, false)
//        return HomeProductViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return products.size
//    }
//
//    override fun onBindViewHolder(holder: HomeProductViewHolder, position: Int) {
//        var product = products[position]
//        holder.tvProductName.text = product.name
//        holder.tvProductPrice.text = "$ ${product.price}"
//        holder.tvProductCategory.text = product.category
//        holder.updateView(position)
//        holder.btnAddCart.setOnClickListener{
//            if(!isProductInCart(product)){
//                //Add Product To Cart
//                Cart.items.add(
//                    CartItem(product,1)
//                )
//                Toast.makeText(context,"Product added to cart", Toast.LENGTH_SHORT).show()
//                holder.updateView(position)
//            }else{
//                // Navigate to Cart Page
//                val intent = Intent(context, MyCartActivity::class.java)
//                context.startActivity(intent)
//            }
//        }
//
//        holder.itemView.setOnClickListener{
//            val intent = Intent(context,ProductDetailsActivity::class.java)
//            intent.putExtra("productKey", product)
//            context.startActivity(intent)
//        }
//
//    }
//
//    fun isProductInCart(product : Product) : Boolean{
//        return Cart.items.indexOfFirst {
//            it.product.id == product.id
//        }!=-1
//    }
//
//
//}