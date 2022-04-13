package com.example.kursakademiaandroida

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.kursakademiaandroida.features.characters.presentation.CharacterFragment
import com.example.kursakademiaandroida.features.episodes.presentation.EpisodeFragment
import com.example.kursakademiaandroida.features.locations.presentation.LocationFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setBottomNavigation()
        showFragment(LocationFragment())
    }

    private fun setBottomNavigation() {
        val bottomNavigation: BottomNavigationView = findViewById(R.id.nav_view)
        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_location -> {
                    showFragment(LocationFragment())
                    true
                }
                R.id.nav_episode -> {
                    showFragment(EpisodeFragment())
                    true
                }
                R.id.nav_character -> {
                    showFragment(CharacterFragment())
                    true
                }
                else -> {
                    true
                }
            }
        }
    }

    private fun showFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, fragment)
            .commit()

    }
}


