package com.example.bottomnav_v27

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()
        val bottomView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

//        by default home fragment should be visible to the user
//        present in activity_main file
        replaceWithFragment(Home())
//        passing the home class fragment

        bottomView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.item1 -> replaceWithFragment(Home())
                R.id.item2 -> replaceWithFragment(Search())
                R.id.item3 -> replaceWithFragment(Person())
            }
            true
//            items are clickable is telling here by true
        }
    }

    private fun replaceWithFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.replace(R.id.frameLayout, fragment)
//                                home se replace   which ever is clicked
        fragmentTransaction.commit()
    }
}