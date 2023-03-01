package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.adapters.HomeProductAdapter
import com.example.myapplication.data.Cart
import com.example.myapplication.data.Products
import com.example.myapplication.ui.MyCartActivity

class MainActivity : AppCompatActivity(), HomeProductAdapter.HomeScreenListener {
    lateinit var rvProducts : RecyclerView
    lateinit var btnCart : ImageButton
    lateinit var tvCartCount : TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbarHome))
        supportActionBar?.title = null
        rvProducts = findViewById(R.id.rvProductsHome)
        btnCart = findViewById(R.id.btnCart)
        tvCartCount=findViewById(R.id.tvCountCartItems)

        btnCart.setOnClickListener{
            val intent = Intent(this,MyCartActivity::class.java)
//            startActivity(intent)
            startActivityForResult(intent,100)
        }

//        Products.allProducts.add(Product(1,"T-Shirt","Fashion",200))
//        Products.allProducts.add(Product(2,"T-Shirt-2","Fashion",300))
//        Products.allProducts.add(Product(3,"T-Shirt","Fashion",400))
//        Products.allProducts.add(Product(4,"T-Shirt","Fashion",250))
        setProducts()
    }

    private fun setProducts(){
        rvProducts.apply {
            adapter = HomeProductAdapter(Products.allProducts,this@MainActivity)
            layoutManager = GridLayoutManager(this@MainActivity,2)
        }
    }

    override fun updateCartCount() {
        tvCartCount.text = Cart.itemsCount().toString()
    }

//    override fun onResume() {
//        updateCartCount()
//        setProducts()
//        super.onResume()
//    }

    override fun onStart() {
//        Toast.makeText(this,"onStart",Toast.LENGTH_SHORT).show()
        super.onStart()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val res = data?.getBooleanExtra("key1",false)
        if(res==true){
            Toast.makeText(this,res.toString(),Toast.LENGTH_SHORT).show()
            rvProducts.adapter?.notifyDataSetChanged()
            updateCartCount()
        }



    }








//    fun updateViews(){
//        tvCartCount.text = Cart.itemsCount().toString()
//    }
}