package com.example.myapplication.adapters

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.data.Cart
import com.example.myapplication.models.CartItem
import com.example.myapplication.models.Product

class CartItemAdapter (private val cartItems : ArrayList<CartItem>, private val context : Context) : RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder>() {
    var cartScreenListener : CartScreenListener?=null
    private var arrayAdapter = ArrayAdapter<Int>(
        context,
        com.google.android.material.R.layout.support_simple_spinner_dropdown_item,
        arrayOf<Int>(1,2,3,4,5)
    )

    inner class CartItemViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val tvProductName = view.findViewById<TextView>(R.id.tvNameProductCart)!!
        val tvProductCategory =  view.findViewById<TextView>(R.id.tvCategoryProductCart)!!
        val tvProductPrice =  view.findViewById<TextView>(R.id.tvPriceProductCart)!!
        val imgProduct = view.findViewById<ImageView>(R.id.imgProductCart)!!
        val ddItemCount = view.findViewById<Spinner>(R.id.ddItemCount)!!
        val btnDeleteCart = view.findViewById<Button>(R.id.btnDeleteCart)!!
        init {
            cartScreenListener = context as CartScreenListener
        }

    }

    interface CartScreenListener{
        fun setCartItems()
        fun updateAmount(orderAmount : Int, totalAmount : Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartItemViewHolder {
        val view  = LayoutInflater.from(context).inflate(R.layout.cart_product_view, parent, false)
        return CartItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CartItemViewHolder, position: Int) {
        val item = cartItems[position]
        val product = item.product
        holder.tvProductName.text = product.name
        holder.tvProductPrice.text = "$ ${product.price}"
        holder.tvProductCategory.text = product.category
        holder.imgProduct.setImageResource(product.img)
        holder.ddItemCount.adapter = arrayAdapter
        holder.ddItemCount.setSelection(cartItems[position].count-1)
                                                    //Anonymous Inner Class
        holder.ddItemCount.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                var value = parent?.getItemAtPosition(pos) as Int
                item.count = value
                holder.ddItemCount.setSelection(value-1)
                //Update Order, Total Amount
                cartScreenListener?.updateAmount(getAmount(),getAmount())
            }
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        holder.btnDeleteCart.setOnClickListener{
            //Remove Product From Cart
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                cartItems.removeIf {
                    it.product.id==product.id
                }
                //Refresh Cart View
                cartScreenListener?.setCartItems()
                //Update Order, Total Amount
                cartScreenListener?.updateAmount(getAmount(),getAmount())

            }
        }
    }

    override fun getItemCount(): Int {
        return cartItems.size
    }

    fun getAmount() : Int{
        var amount=0
        for(item in Cart.items){
            amount+=(item.count*item.product.price)
        }
        return amount
    }


}