package com.trifcdr.authorization.fragment

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.hbb20.CountryCodePicker
import com.trifcdr.authorization.databinding.FragmentAuthorizationBinding
import com.trifcdr.authorization.di.AuthorizationComponentHolder
import com.trifcdr.authorization.navigation.AuthorizationDirections
import com.trifcdr.authorization.navigation.SendCodeToCheckArgs
import com.trifcdr.authorization.viewmodel.AuthViewModelFactory
import com.trifcdr.authorization.viewmodel.AuthorizationViewModel
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.navigationapi.NavigationApi
import javax.inject.Inject

class SendCodeFragment : Fragment() {

    private lateinit var binding: FragmentAuthorizationBinding

    private lateinit var viewModel: AuthorizationViewModel

    private lateinit var ccp: CountryCodePicker
    private lateinit var phone: EditText
    private lateinit var getCode: Button

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
        init()
        addTextChangedListener()
        setCodeObserver()
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

    private fun setCodeObserver() {
        viewModel.resultSendCode.observe(viewLifecycleOwner) { sendCodeResult ->
            if (sendCodeResult is DomainResource.Success) {
                navigationApi.navigate(AuthorizationDirections.ToCodeCheck(getCheckCodeArgs()))
            }
        }
    }

    private fun getCheckCodeArgs(): SendCodeToCheckArgs = SendCodeToCheckArgs(
        phone = getNumber()
    )

    private fun setClickListeners() {
        getCode.setOnClickListener {
            viewModel.sendAuthCode(getNumber())
        }
    }

    private fun addTextChangedListener() {
        phone.addTextChangedListener(object : TextWatcher {
            private var lastChar = ""
            private var len = 0
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val digits = phone.text.length
                if (digits > 1) {
                    lastChar = phone.text.toString().substring(digits - 1)
                }

            }

            @SuppressLint("SetTextI18n")
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val digits = phone.text.length
                if (lastChar != "-") {
                    if ((digits == 5 || digits == 9 || digits == 12) && len < digits) {
                        phone.append("-")
                    }
                    if (p0 != null) {
                        if (digits == 3 && len < digits && !p0.contains("(") && !p0.contains(")")) {
                            phone.setText("($p0)")
                            phone.setSelection(phone.text.length)
                        }
                        if (digits == 4 && len < digits && p0.contains("(") && !p0.contains(")")) {
                            phone.append(")")
                        }
                    }
                }
                len = digits
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }

    private fun getNumber(): String {
        return ccp.selectedCountryCodeWithPlus + phone.text.toString()
            .replace("-", "")
            .replace("(", "")
            .replace(")", "")
    }

    private fun init() {
        viewModel = ViewModelProvider(this, authViewModelFactory)[AuthorizationViewModel::class]
        ccp = binding.ccp
        phone = binding.etPhone
        getCode = binding.getCodeBt
    }
}