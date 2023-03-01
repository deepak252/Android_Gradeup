package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.R
import com.example.myapplication.data.Cart
import com.example.myapplication.data.Products
import com.example.myapplication.models.CartItem
import com.example.myapplication.models.Product

class ProductDetailsActivity : AppCompatActivity() {
    private lateinit var imgProduct : ImageView
    private lateinit var tvProductTitle : TextView
    private lateinit var tvProductCategory : TextView
    private lateinit var tvProductPrice : TextView
    private lateinit var btnAddCart : Button
    private lateinit var product: Product
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        setSupportActionBar(findViewById(R.id.toolbarProductDetails))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title=null

        imgProduct = findViewById(R.id.imgProductDetails)
        tvProductTitle = findViewById(R.id.tvTitleProductDetails)
        tvProductCategory = findViewById(R.id.tvCategoryProductDetails)
        tvProductPrice = findViewById(R.id.tvPriceProductDetails)
        btnAddCart = findViewById(R.id.btnAddCart2)

        product = intent.extras?.getParcelable<Product>("productKey") as Product

        tvProductTitle.text = product.name.toString()
        tvProductPrice.text = "$ ${product.price}"
        tvProductCategory.text = product.category.toString()
        imgProduct.setImageResource(product.img)

        updateView(product)

        btnAddCart.setOnClickListener{
            if(!isProductInCart(product)){
                //Add Product To Cart
                Cart.items.add(
                    CartItem(product,1)
                )
                Toast.makeText(this,"Product added to cart", Toast.LENGTH_SHORT).show()
                updateView(product)
//                holder.updateView(position)
            }else{
                // Navigate to Cart Page
                val intent = Intent(this, MyCartActivity::class.java)
                startActivity(intent)
            }
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home->{
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun isProductInCart(product : Product) : Boolean{
        return Cart.items.indexOfFirst {
            it.product.id == product.id
        }!=-1
    }

    private fun updateView(product : Product){
        if(isProductInCart(product)){
            btnAddCart.text="Go To Cart"

        }else{
            btnAddCart.text = "Add To Cart"
        }
//        homeScreenListener?.updateCartCount()
    }

    override fun onResume() {
        if(product!=null){
            updateView(product)
        }
        super.onResume()
    }




}