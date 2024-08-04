package com.trifcdr.messanger

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.trifcdr.navigationimpl.NavigationActivity
import com.trifcdr.navigationimpl.NavigationFragment

internal class MainActivity :AppCompatActivity(), NavigationActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun getNavigationFragment(): NavigationFragment? = supportFragmentManager.fragments
        .filterIsInstance<NavigationFragment>()
        .firstOrNull()
}