package com.trifcdr.profile.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.profile.R
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

    private lateinit var nickname: TextView
    private lateinit var id: TextView
    private lateinit var phone: TextView
    private lateinit var city: TextView
    private lateinit var birthday: TextView
    private lateinit var horoscope: TextView


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
        setProfileDataObserver()
        return binding.root
    }

    private fun setProfileDataObserver() {
        viewModel.resultProfileData.observe(viewLifecycleOwner){ profileData ->
            if (profileData is DomainResource.Success){
                val res = profileData.result
                nickname.text = res.username
                id.text = res.id.toString()
                phone.text = buildString {
                    append("+")
                    append(res.phone)
                }
                if(res.city == null){
                    city.text = getString(R.string.no_data)
                }
                else{
                    city.text = res.city
                }
                if(res.birthday == null){
                    birthday.text = getString(R.string.no_data)
                }
                else{
                    birthday.text = res.birthday
                }
                horoscope.text = ""
            }
        }
    }

    private fun init() {
        viewModel = ViewModelProvider(this, profileViewModelFactory)[ProfileViewModel::class]
        nickname = binding.nickname
        id = binding.id
        phone = binding.phone
        city = binding.city
        birthday = binding.birthday
        horoscope = binding.horoscope
        viewModel.getProfileData()
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