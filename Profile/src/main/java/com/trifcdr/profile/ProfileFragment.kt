package com.trifcdr.profile

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.profile.databinding.FragmentProfileBinding
import com.trifcdr.profile.di.ProfileComponentHolder
import com.trifcdr.profile.navigation.ProfileDirections
import com.trifcdr.profile.viewmodel.ProfileViewModel
import com.trifcdr.profile.viewmodel.ProfileViewModuleFactory
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
class ProfileFragment: Fragment() {

    private lateinit var binding: FragmentProfileBinding


    @Inject
    lateinit var profileViewModelFactory: ProfileViewModuleFactory

    @Inject
    lateinit var navigationApi: NavigationApi<ProfileDirections>

    private lateinit var viewModel: ProfileViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentProfileBinding.inflate(layoutInflater, container, false)
        init()
//        setClickListeners()
//        setCheckObserver()
        return binding.root
    }

    private fun init() {
        viewModel = ViewModelProvider(this, profileViewModelFactory)[ProfileViewModel::class]

    }

    override fun onAttach(context: Context) {
        ProfileComponentHolder.get()
            .inject(this)
        super.onAttach(context)
    }

    override fun onDetach() {
        if (isRemoving) {
            ProfileComponentHolder.clear()
        }
        super.onDetach()
    }
}