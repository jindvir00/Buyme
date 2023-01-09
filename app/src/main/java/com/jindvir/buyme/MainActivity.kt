package com.jindvir.buyme

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.imageview.ShapeableImageView

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bm = findViewById<BottomNavigationView>(R.id.btm_nav_view)
        val si = findViewById<ShapeableImageView>(R.id.profile_si)
        loadFragment(Profile())
        bm.setOnItemSelectedListener { item ->

            val fragment: Fragment
            when (item.itemId) {
                R.id.home -> {
                    fragment = Home()
                    loadFragment(fragment)
                    true
                }
//                R.id.scan -> {
//                    fragment = Profile()
//                    loadFragment(fragment)
//                    true
//
//                }
                R.id.cart -> {
                    fragment = Cart()
                    loadFragment(fragment)
                    true

                }
                else -> false
            }


        }

        si.setOnClickListener {
            supportFragmentManager.beginTransaction()
                .replace(R.id.linearlayout_ll, Profile())
                .commit()

            si.visibility = View.INVISIBLE
//            bm.visibility = View.INVISIBLE

        }

    }

    // function to open fragment
    fun loadFragment(fragment: Fragment) {
        // load fragment
        supportFragmentManager.beginTransaction()
            .replace(R.id.linearlayout_ll, fragment)
            .commit()

        val si = findViewById<ShapeableImageView>(R.id.profile_si)
        si.visibility = View.VISIBLE
    }
}