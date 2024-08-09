package com.trifcdr.authorization

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.trifcdr.authorization.databinding.FragmentAuthorizationBinding
import com.trifcdr.authorization.di.AuthorizationComponentHolder
import com.trifcdr.authorization.navigation.AuthorizationDirections
import com.trifcdr.common.di.DaggerNetworkModuleComponent
import com.trifcdr.common.di.NetworkModuleComponent
import com.trifcdr.data.repository.AuthorizationRepository
import com.trifcdr.data.repository.AuthorizationRepositoryImpl
import com.trifcdr.navigationapi.NavigationApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class AuthorizationFragment : Fragment() {

    private lateinit var binding: FragmentAuthorizationBinding

    @Inject
    lateinit var navigationApi: NavigationApi<AuthorizationDirections>

    private lateinit var authRepo: AuthorizationRepository

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        val networkComponent: NetworkModuleComponent = DaggerNetworkModuleComponent.create()
        authRepo = AuthorizationRepositoryImpl(networkComponent.provideNetwork())

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
            Toast.makeText(context, "!!!", Toast.LENGTH_SHORT).show()
            //navigationApi.navigate(AuthorizationDirections.ToRegistration)
            CoroutineScope(Dispatchers.IO).launch {
                authRepo.sendAuthCode("+79209996354")
            }
        }
    }
}