package com.trifcdr.registration.fragment

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.os.Parcelable
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.RegisterUser
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.registration.databinding.FragmentRegistrationBinding
import com.trifcdr.registration.di.RegistrationComponentHolder
import com.trifcdr.registration.navigation.RegistrationArgs
import com.trifcdr.registration.navigation.RegistrationDirections
import com.trifcdr.registration.viewmodel.RegisterViewModelFactory
import com.trifcdr.registration.viewmodel.RegistrationViewModel
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

    private lateinit var rules: LinearLayoutCompat

    private lateinit var upCase: TextView
    private lateinit var lowCase: TextView
    private lateinit var digits: TextView
    private lateinit var symbols: TextView

    private var upCaseFlag: Boolean = false
    private var lowCaseFlag: Boolean = false
    private var digitsFlag: Boolean = false
    private var symbolsFlag: Boolean = false

    @Inject
    lateinit var navigationApi: NavigationApi<RegistrationDirections>

    @Inject
    lateinit var registerViewModelFactory: RegisterViewModelFactory

    private lateinit var viewModel: RegistrationViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        init()
        setClickListeners()
        addTextChangesListeners()
        setRegisterObserver()
        return binding.root
    }

    private fun setRegisterObserver() {
        viewModel.resultRegisterUser.observe(viewLifecycleOwner){ registerResult ->
            if (registerResult is DomainResource.Success) {
                navigationApi.navigate(RegistrationDirections.ToProfile)
            }
            if (registerResult is DomainResource.Failure){
                Toast.makeText(context, "Ошибка регистрации. Повторите попытку", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun addTextChangesListeners() {
        username.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(chSeq: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (chSeq != null) {
                    rules.visibility = View.VISIBLE
                    if (chSeq.any {it.isUpperCase()}){
                        upCase.setTextColor(Color.GREEN)
                        upCaseFlag = true
                    }
                    else{
                        upCase.setTextColor(Color.RED)
                        upCaseFlag = false
                    }
                    if (chSeq.any {it.isLowerCase()}){
                        lowCase.setTextColor(Color.GREEN)
                        lowCaseFlag = true
                    }
                    else{
                        lowCase.setTextColor(Color.RED)
                        lowCaseFlag = false
                    }
                    if (chSeq.any {it.isDigit()}){
                        digits.setTextColor(Color.GREEN)
                        digitsFlag = true
                    }
                    else{
                        digits.setTextColor(Color.RED)
                        digitsFlag = false
                    }
                    if (chSeq.any {it in "-_"}){
                        symbols.setTextColor(Color.GREEN)
                        symbolsFlag = true
                    }
                    else{
                        symbols.setTextColor(Color.RED)
                        symbolsFlag = false
                    }

                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }

    private fun init() {
        viewModel = ViewModelProvider(this, registerViewModelFactory)[RegistrationViewModel::class]
        regBtn = binding.register
        phone = binding.phone
        phone.setText(args.phone)
        name = binding.name
        username = binding.username
        rules = binding.rules
        lowCase = binding.lowCase
        upCase = binding.upCase
        digits = binding.digits
        symbols = binding.symbols
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
        regBtn.setOnClickListener {
            if(upCaseFlag && lowCaseFlag && digitsFlag && symbolsFlag && name.text.toString() != ""){
                viewModel.registerUser(
                    getRegisterUser()
                )
            }
        }
    }

    private fun getRegisterUser(): RegisterUser {
        return RegisterUser(
            phone = args.phone,
            name = name.text.toString(),
            username = username.text.toString()
        )
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