package com.example.retrofitexample3.adapters

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.retrofitexample3.R
import com.example.retrofitexample3.UserDetailsActivity
import com.example.retrofitexample3.models.UserData

class UsersAdapter(private val users : MutableList<UserData>, private val context : Activity) : RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {
    class UserViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val imgUser: ImageView
        val tvName : TextView
        val tvEmail : TextView
        init {
            imgUser = view.findViewById(R.id.imgU1)
            tvName = view.findViewById(R.id.tvName1)
            tvEmail = view.findViewById(R.id.tvEmail1)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.user_list_item,parent,false)
        return UserViewHolder((view))
    }

    override fun getItemCount(): Int {
        return users.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.tvName.text = "${user.firstName} ${user.lastName}"
        holder.tvEmail.text =  user.email
        Glide.with(context).load(user.avatar)
            .placeholder(R.drawable.baseline_person_24)
            .into(holder.imgUser)


        holder.itemView.setOnClickListener{
            val intent = Intent(context, UserDetailsActivity::class.java)
            intent.putExtra("userId", user.id)
            context.startActivity(intent)
        }


    }
}