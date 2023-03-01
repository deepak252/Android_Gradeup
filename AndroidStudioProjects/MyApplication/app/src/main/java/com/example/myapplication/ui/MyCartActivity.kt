package com.example.myapplication.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.adapters.CartItemAdapter
import com.example.myapplication.data.Cart

class MyCartActivity : AppCompatActivity(), CartItemAdapter.CartScreenListener {
    lateinit var rvCart : RecyclerView
    lateinit var tvOrderAmount : TextView
    lateinit var tvTotalAmount : TextView
    var datasetChanged = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_cart)

        rvCart = findViewById(R.id.rvCartItems)
        tvOrderAmount = findViewById(R.id.tvOrderAmount)
        tvTotalAmount = findViewById(R.id.tvTotalAmount)

        setSupportActionBar(findViewById(R.id.toolbarCart))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.title=null

        setCartItems()

    }

    override fun setCartItems(){
        rvCart.adapter = CartItemAdapter(Cart.items,this)
        rvCart.layoutManager = LinearLayoutManager(this)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            android.R.id.home->{
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun updateAmount(orderAmount : Int, totalAmount : Int) {
        tvOrderAmount.text = "$ $orderAmount"
        tvTotalAmount.text = "$ $totalAmount"
    }

    override fun onBackPressed() {

        val intent = Intent()
//        intent.putExtra("key1", "Test")
        intent.putExtra("key1", datasetChanged)
        setResult(100,intent)
        super.onBackPressed()

    }



}