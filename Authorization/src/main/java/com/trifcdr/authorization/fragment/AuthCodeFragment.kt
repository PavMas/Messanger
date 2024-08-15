package com.trifcdr.authorization.fragment

import android.content.Context
import android.os.Bundle
import android.os.Parcelable
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.trifcdr.authorization.databinding.FragmentCodeBinding
import com.trifcdr.authorization.di.AuthorizationComponentHolder
import com.trifcdr.authorization.navigation.AuthorizationDirections
import com.trifcdr.authorization.navigation.CheckCodeArgs
import com.trifcdr.authorization.navigation.CheckCodeToRegistrationArgs
import com.trifcdr.authorization.viewmodel.AuthViewModelFactory
import com.trifcdr.authorization.viewmodel.AuthorizationViewModel
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.navigationapi.NavigationApi
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
class AuthCodeFragment : Fragment() {

    private lateinit var binding: FragmentCodeBinding

    private lateinit var code: LinearLayoutCompat

    private lateinit var digit1: EditText
    private lateinit var digit2: EditText
    private lateinit var digit3: EditText
    private lateinit var digit4: EditText
    private lateinit var digit5: EditText
    private lateinit var digit6: EditText
    private lateinit var checkBtn: Button

    private val args by getArgs<CheckCodeArgs>()

    @Inject
    lateinit var authViewModelFactory: AuthViewModelFactory

    @Inject
    lateinit var navigationApi: NavigationApi<AuthorizationDirections>

    private lateinit var viewModel: AuthorizationViewModel


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCodeBinding.inflate(layoutInflater, container, false)
        init()
        setClickListeners()
        setCheckObserver()
        addTextChangesListeners()
        return binding.root
    }

    private fun setCheckObserver() {
        viewModel.resultCheckCode.observe(viewLifecycleOwner){ checkCodeResult ->
            if (checkCodeResult is DomainResource.Success) {
                if (!checkCodeResult.result.isUserExist){
                    navigationApi.navigate(AuthorizationDirections.ToRegistration(getRegistrationArgs()))
                }
                Toast.makeText(context, checkCodeResult.result.userId.toString(), Toast.LENGTH_SHORT).show()
            }
            if (checkCodeResult is DomainResource.Failure){
                Toast.makeText(context, checkCodeResult.exception.message, Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun getRegistrationArgs(): CheckCodeToRegistrationArgs {
        return CheckCodeToRegistrationArgs(args.phone)
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

    private fun init() {
        viewModel = ViewModelProvider(this, authViewModelFactory)[AuthorizationViewModel::class]
        code = binding.codeLayout
        digit1 = binding.digit1
        digit2 = binding.digit2
        digit3 = binding.digit3
        digit4 = binding.digit4
        digit5 = binding.digit5
        digit6 = binding.digit6
        checkBtn = binding.checkCode
    }

    private fun setClickListeners() {
        code.setOnClickListener {
            digit1.requestFocus()
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(digit1, InputMethodManager.SHOW_IMPLICIT)
        }
        checkBtn.setOnClickListener {
            val res = digit1.text.toString() +
                    digit2.text.toString() +
                    digit3.text.toString() +
                    digit4.text.toString() +
                    digit5.text.toString() +
                    digit6.text.toString()
            if (res.length == 6) {
                viewModel.checkAuthCode(args.phone, res)
            }
        }
    }

    private fun addTextChangesListeners() {
        digit1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val digits = digit1.text.length
                if (digits == 1) {
                    digit2.isClickable = true
                    digit2.requestFocus()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        digit2.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val digits = digit2.text.length
                if (digits == 1) {
                    digit3.isClickable = true
                    digit3.requestFocus()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        digit3.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val digits = digit3.text.length
                if (digits == 1) {
                    digit4.isClickable = true
                    digit4.requestFocus()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })

        digit4.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val digits = digit4.text.length
                if (digits == 1) {
                    digit5.isClickable = true
                    digit5.requestFocus()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
        digit5.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val digits = digit5.text.length
                if (digits == 1) {
                    digit6.isClickable = true
                    digit6.requestFocus()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
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