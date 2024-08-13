package com.trifcdr.authorization

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import com.trifcdr.authorization.databinding.FragmentCodeBinding

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


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentCodeBinding.inflate(layoutInflater, container, false)
        init()
        setClickListeners()
        addTextChangesListeners()
        return binding.root
    }

    private fun init() {
        code = binding.codeLayout
        digit1 = binding.digit1
        digit2 = binding.digit2
        digit3 = binding.digit3
        digit4 = binding.digit4
        digit5 = binding.digit5
        digit6 = binding.digit6
    }

    private fun setClickListeners() {
        code.setOnClickListener {
            digit1.requestFocus()
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(digit1, InputMethodManager.SHOW_IMPLICIT)
        }
    }

    private fun addTextChangesListeners() {
        digit1.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val digits = digit1.text.length
                if (digits == 1) {
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
                    digit6.requestFocus()
                }
            }

            override fun afterTextChanged(p0: Editable?) {
            }

        })
    }
}