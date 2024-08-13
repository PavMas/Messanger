package com.trifcdr.authorization

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.trifcdr.authorization.databinding.FragmentAuthorizationBinding
import com.trifcdr.authorization.di.AuthorizationComponentHolder
import com.trifcdr.authorization.navigation.AuthorizationDirections
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.navigationapi.NavigationApi
import javax.inject.Inject

class AuthorizationFragment : Fragment() {

    private lateinit var binding: FragmentAuthorizationBinding

    private lateinit var viewModel: AuthorizationViewModel

    @Inject
    lateinit var navigationApi: NavigationApi<AuthorizationDirections>

    @Inject
    lateinit var authViewModelFactory: AuthViewModelFactory


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentAuthorizationBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this, authViewModelFactory)[AuthorizationViewModel::class]
        setClickListeners()
        viewModel.resultSendCode.observe(viewLifecycleOwner) { sendCodeResult ->
            if (sendCodeResult is DomainResource.Success) {
                val k = sendCodeResult.result.isSuccessful

            }
        }
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
            viewModel.sendAuthCode("+79209996356")
        }
    }
}