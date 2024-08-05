package com.trifcdr.registration

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.registration.databinding.FragmentRegistrationBinding
import com.trifcdr.registration.di.RegistrationComponentHolder
import com.trifcdr.registration.navigation.RegistrationDirections
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
class RegistrationFragment : Fragment() {

    private lateinit var binding: FragmentRegistrationBinding

    @Inject
    lateinit var navigationApi: NavigationApi<RegistrationDirections>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegistrationBinding.inflate(inflater, container, false)
        setClickListeners()
        return binding.root
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
        binding.run {
//            buttonToFeature3.setOnClickListener {
//                navigationApi.navigate(RegistrationDirections.ToFeature3(getFeature2To3Args()))
//            }
            buttonBack.setOnClickListener {
                navigationApi.navigate(RegistrationDirections.ToAuthorization)
            }
        }
    }

//    private fun getFeature2To3Args(): Feature2To3Args = Feature2To3Args(
//        someArg1 = 2,
//        someArg2 = "Previous Feature Number",
//    )

}