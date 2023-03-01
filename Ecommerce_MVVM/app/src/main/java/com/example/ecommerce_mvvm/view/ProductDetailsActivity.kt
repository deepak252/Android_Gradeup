package com.example.ecommerce_mvvm.view

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.ecommerce_mvvm.R
import com.example.ecommerce_mvvm.model.Product


class ProductDetailsActivity : AppCompatActivity() {
    lateinit var imgProduct : ImageView
    lateinit var tvTitle : TextView
    lateinit var tvDesc : TextView
    lateinit var tvPrice : TextView
    lateinit var tvCategory : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)

        initViews()

        val product = intent.extras?.getParcelable<Product>("productKey")
        if(product!=null){
            tvTitle.text = product.title
            tvPrice.text = "₹ ${product.price}"
            tvCategory.text = product.category
            tvDesc.text = product.description
            Glide.with(this)
                .load(product.imgUrl)
                .placeholder(R.drawable.app_icon)
                .into(imgProduct)

        }else{
            Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show()
        }

    }

    private fun initViews(){
        tvTitle = findViewById(R.id.tvProductTitle2)
        tvDesc = findViewById(R.id.tvProductDesc2)
        tvCategory = findViewById(R.id.tvProductCategory2)
        tvPrice = findViewById(R.id.tvProductPrice2)
        imgProduct = findViewById(R.id.imgProduct2)
    }

    override fun onBackPressed() {
        val returnIntent = Intent()
        returnIntent.putExtra("result", "Returned Intent")
        setResult(1, returnIntent)
        super.onBackPressed()
    }
}