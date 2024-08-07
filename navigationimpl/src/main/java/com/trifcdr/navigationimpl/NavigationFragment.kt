package com.trifcdr.navigationimpl

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.trifcdr.navigationimpl.databinding.FragmentNavigationBinding

class NavigationFragment : Fragment() {

    private lateinit var binding: FragmentNavigationBinding

    private lateinit var bottomNavigation: BottomNavigationView

    val navController: NavController by lazy {
        (childFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment).navController
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentNavigationBinding.inflate(inflater, container, false)
        bottomNavigation = binding.bottomNavigationView
        binding.bottomNavigationView.setupWithNavController(navController)
        setupBackButton()
        return binding.root
    }

    private fun setupBackButton() {
        activity?.onBackPressedDispatcher?.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    if (!navController.navigateUp()) {
                        activity?.finish()
                    }
                }
            }
        )
    }
}