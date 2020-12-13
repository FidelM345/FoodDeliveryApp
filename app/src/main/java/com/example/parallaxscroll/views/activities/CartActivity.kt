package com.example.parallaxscroll.views.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.parallaxscroll.R
import com.example.parallaxscroll.views.fragments.CartFragment

class CartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_one)


        val allMoviesFragment = CartFragment()
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, allMoviesFragment)
        transaction.commit()
    }
}