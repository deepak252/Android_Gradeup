package com.example.ecommerceapp.adapters

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ecommerceapp.R
import com.example.ecommerceapp.model.Product
import com.example.ecommerceapp.view.ProductDetailsActivity

class HomeProductsAdapter(private val products : ArrayList<Product>, private val context : Activity) : RecyclerView.Adapter<HomeProductsAdapter.ProductsViewHolder>() {
    class ProductsViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        var tvTitle : TextView
        var tvPrice : TextView
        var tvCategory : TextView
        var imgProduct : ImageView
//        val tvPrice = view.findViewById<TextView>(R.id.tvProductPrice1)
//        val tvCategory = view.findViewById<TextView>(R.id.tvProductCategory1)

        init {
            tvTitle = view.findViewById<TextView>(R.id.tvProductTitle1)
            tvPrice = view.findViewById<TextView>(R.id.tvProductPrice1)
            tvCategory = view.findViewById<TextView>(R.id.tvProductCategory1)
            imgProduct = view.findViewById(R.id.imgProduct1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_product_home, parent, false)
        return ProductsViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsViewHolder, position: Int) {
        val product = products[position]
        holder.tvTitle.text = product.title
        holder.tvPrice.text = "₹ ${product.price}"
        holder.tvCategory.text = product.category

        holder.itemView.setOnClickListener{
            val intent = Intent(context,ProductDetailsActivity::class.java)
            intent.putExtra("productKey", product)
//            context.startActivity(intent)

            context.startActivityForResult(intent,1)

        }

        Glide.with(context).load(product.imgUrl)
            .placeholder(R.drawable.app_icon)
            .fitCenter()
            .into(holder.imgProduct)

    }

    override fun getItemCount(): Int {
        return products.size
    }

}