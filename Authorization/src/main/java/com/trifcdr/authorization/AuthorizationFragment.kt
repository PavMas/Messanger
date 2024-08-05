package com.trifcdr.authorization

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.trifcdr.authorization.databinding.FragmentAuthorizationBinding
import com.trifcdr.authorization.di.AuthorizationComponent
import com.trifcdr.authorization.di.AuthorizationComponentHolder
import com.trifcdr.authorization.navigation.AuthorizationDirections
import com.trifcdr.navigationapi.NavigationApi
import javax.inject.Inject

class AuthorizationFragment : Fragment() {

    private lateinit var binding: FragmentAuthorizationBinding

    @Inject
    lateinit var navigationApi: NavigationApi<AuthorizationDirections>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        setClickListeners()
        return binding.root
    }

    override fun onAttach(context: Context) {
        AuthorizationComponentHolder.get()
            .inject(this)
        super.onAttach(context)
    }

    override fun onDetach() {
        if (isRemoving) {
            AuthorizationComponentHolder.clear()
        }
        super.onDetach()
    }

    private fun setClickListeners() {
        binding.button.setOnClickListener {
            navigationApi.navigate(AuthorizationDirections.ToRegistration)
        }
    }
}