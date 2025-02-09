package com.bignerdranch.android.praktika19_lobanov

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val currentFragment=supportFragmentManager.findFragmentById(R.layout.fragmentcrime)
        if(currentFragment==null){
            val fragment=CrimeFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container,fragment)
                .commit()
        }
    }
}