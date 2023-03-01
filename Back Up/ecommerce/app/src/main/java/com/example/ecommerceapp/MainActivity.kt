package com.example.ecommerceapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.FrameLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.ecommerceapp.controller.ProductController
import com.example.ecommerceapp.model.Product
import com.example.ecommerceapp.view.CartFragment
import com.example.ecommerceapp.view.HomeFragment
import com.example.ecommerceapp.view.ProductDetailsActivity
import com.example.ecommerceapp.view.ProfileFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNav : BottomNavigationView
    private val homeFragment = HomeFragment()
    private val cartFragment = CartFragment()
    private val profileFragment = ProfileFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val products = arrayListOf<Product>(
//            Product(1,109.9,"Foldsack No. 1 Backpack","Men's clothing","Your perfect pack for everyday use and walks in the forest."),
//            Product(2,55.0,"Foldsack No. 1 Backpack","Men's clothing","Your perfect pack for everyday use and walks in the forest."),
//            Product(3,101.1,"Foldsack No. 1 Backpack","Men's clothing","Your perfect pack for everyday use and walks in the forest."),
//        )

        initBottomNav()

    }

    private fun initBottomNav() {
        bottomNav = findViewById(R.id.bottomNav)
        bottomNav.selectedItemId = R.id.navHome

        supportFragmentManager.beginTransaction()
            .replace(R.id.frameDashboard, homeFragment)
            .commit()

        bottomNav.setOnItemSelectedListener{
            menuItem->when(menuItem.itemId){
                R.id.navHome->{
                    if(!homeFragment.isAdded){
                        loadFragment(homeFragment)
                    }
                }
                R.id.navCart->{
                    val intent = Intent(this, ProductDetailsActivity::class.java)
                    intent.putExtra("productKey", ProductController.getProducts()[0])
                    startActivityForResult(intent,1)
//                    if(!cartFragment.isAdded){
//                        loadFragment(cartFragment)
//                    }
                }
                R.id.navProfile->{
                    if(!profileFragment.isAdded){
                        loadFragment(profileFragment)
                    }
                }
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.frameDashboard, fragment)
            .commit()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        val res = data?.getStringExtra("result")
        Toast.makeText(this,res.toString(),Toast.LENGTH_SHORT).show()

    }



}