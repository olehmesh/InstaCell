package com.olehmesh.instacell

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import com.olehmesh.instacell.fragments.fragment_account.FragmentAccount
import com.olehmesh.instacell.fragments.fragment_add.FragmentAdd
import com.olehmesh.instacell.fragments.fragment_favorites.FragmentFavorites
import com.olehmesh.instacell.fragments.fragment_main.FragmentMain
import com.olehmesh.instacell.fragments.fragment_search.FragmentSearch
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(FragmentMain())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.search -> {
                    loadFragment(FragmentSearch())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.add -> {
                    loadFragment(FragmentAdd())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.favorites -> {
                    loadFragment(FragmentFavorites())
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.account -> {
                    loadFragment(FragmentAccount())
                    return@setOnNavigationItemSelectedListener true
                }
            }
            false
        }

    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.nav_host_fragment, fragment)
        transaction.disallowAddToBackStack()
        transaction.commit()
    }

}