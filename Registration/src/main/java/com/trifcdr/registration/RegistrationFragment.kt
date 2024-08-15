package com.trifcdr.registration

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.registration.databinding.FragmentRegistrationBinding
import com.trifcdr.registration.di.RegistrationComponentHolder
import com.trifcdr.registration.navigation.RegistrationArgs
import com.trifcdr.registration.navigation.RegistrationDirections
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding

    private val args by getArgs<RegistrationArgs>()

    private lateinit var regBtn: Button
    private lateinit var phone: EditText
    private lateinit var name: EditText
    private lateinit var username: EditText

    @Inject
    lateinit var navigationApi: NavigationApi<RegistrationDirections>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        init()
        setClickListeners()
        return binding.root
    }

    private fun init() {
        regBtn = binding.register
        phone = binding.phone
        phone.setText(args.phone)
        name = binding.name
        username = binding.username
    }

    override fun onAttach(context: Context) {
        RegistrationComponentHolder.get()
            .inject(this)
        super.onAttach(context)
    }

    override fun onDetach() {
        if (isRemoving) {
            RegistrationComponentHolder.clear()
        }
        super.onDetach()
    }

    private fun setClickListeners() {

    }

    companion object {
        private const val ARGS_KEY = "phone"

        private val noArgsException: IllegalArgumentException
            get() = IllegalArgumentException("No args provided")

        private val invalidArgsException: IllegalArgumentException
            get() = IllegalArgumentException("Invalid args")

        private fun <ARGS : Parcelable> Fragment.getArgs(): Lazy<ARGS> = lazy {
            (arguments?.takeIf { args -> !args.isEmpty } ?: throw noArgsException)
                .getParcelable<ARGS>(ARGS_KEY)
                ?: throw invalidArgsException
        }
    }

}