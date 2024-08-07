package com.trifcdr.messanger

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.trifcdr.messanger.databinding.ActivityMainBinding
import com.trifcdr.navigationimpl.NavigationActivity
import com.trifcdr.navigationimpl.NavigationFragment

internal class MainActivity: AppCompatActivity(), NavigationActivity {


    private lateinit var binding: ActivityMainBinding

    private lateinit var bottomNavigation: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun getNavigationFragment(): NavigationFragment? = supportFragmentManager.fragments
        .filterIsInstance<NavigationFragment>()
        .firstOrNull()
}