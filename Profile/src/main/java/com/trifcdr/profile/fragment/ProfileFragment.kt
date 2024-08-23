package com.trifcdr.profile.fragment

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.ProfileData
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.profile.R
import com.trifcdr.profile.databinding.FragmentProfileBinding
import com.trifcdr.profile.di.ProfileComponentHolder
import com.trifcdr.profile.navigation.ProfileDirections
import com.trifcdr.profile.navigation.ProfileToEditArgs
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

    private lateinit var vk: LinearLayoutCompat
    private lateinit var inst: LinearLayoutCompat

    private lateinit var editProfile: Button
    private lateinit var logout: Button

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
        setClickListeners()
        setProfileDataObserver()
        return binding.root
    }

    private fun setClickListeners() {
        logout.setOnClickListener {
            binding.progressIndicator.visibility = View.VISIBLE
            viewModel.cleanUserData()
        }
    }

    private fun setSocialsClickListeners(res: ProfileData) {
        if (res.vk != null && res.vk != ""){
            vk.setOnClickListener {
                goToUrl(res.vk!!)
            }
        }
        else{
            Toast.makeText(context, getString(R.string.not_found), Toast.LENGTH_SHORT).show()

        }
        if (res.instagram != null && res.instagram != ""){
            inst.setOnClickListener {
                goToUrl(res.instagram!!)
            }
        }
        else{
            Toast.makeText(context, getString(R.string.not_found), Toast.LENGTH_SHORT).show()

        }

    }

    private fun goToUrl(url: String) {
        val uriUrl = Uri.parse(url)
        val launchBrowser = Intent(Intent.ACTION_VIEW, uriUrl)
        startActivity(launchBrowser)
    }

    private fun setEditClickListener(data: ProfileData) {
        editProfile.setOnClickListener {
            navigationApi.navigate(ProfileDirections.ToProfileEdit(
                ProfileToEditArgs(
                    id = data.id,
                    phone = data.phone,
                    name = data.name,
                    username = data.username,
                    birthday = data.birthday ?: "",
                    city = data.city ?: "",
                    vk = data.vk ?: "",
                    instagram = data.instagram ?: "",
                    status = data.status ?: "",
                    avatar = data.avatar ?: ""
                )
            ))
        }
    }

    private fun setProfileDataObserver() {
        viewModel.resultProfileData.observe(viewLifecycleOwner){ profileData ->
            binding.progressIndicator.visibility = View.GONE
            if (profileData is DomainResource.Success){
                val res = profileData.result
                setSocialsClickListeners(res)
                setEditClickListener(res)
                nickname.text = res.username
                id.text = res.id.toString()
                phone.text = buildString {
                    append("+")
                    append(res.phone)
                }
                if(res.city == null || res.city == ""){
                    city.text = getString(R.string.no_data)
                }
                else{
                    city.text = res.city
                }
                if(res.birthday == null || res.birthday == ""){
                    birthday.text = getString(R.string.no_data)
                }
                else{
                    birthday.text = res.birthday
                    horoscope.text = getZodiac(res.birthday!!)
                }
            }
            else{
                Toast.makeText(context, getString(R.string.retry_letter), Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.resultClearUserData.observe(viewLifecycleOwner){ res ->
            if (res){
                navigationApi.navigate(ProfileDirections.ToAuthorization)
            }
            else{
                Toast.makeText(context, getString(R.string.retry_letter), Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.resultAuth.observe(viewLifecycleOwner){ res->
            if (!res){
                navigationApi.navigate(ProfileDirections.ToAuthorization)
            }
        }
    }

    private fun getZodiac(birthday: String): String {
        val month = birthday.substring(6, 8).toInt()
        val day = birthday.substring(9).toInt()
        if((month == 1) && (day <= 20) || (month == 12) && (day >= 22)) {
            return getString(R.string.capricorn)
        } else if((month == 1) || (month == 2) && (day <= 19)) {
            return getString(R.string.aquarius)
        } else if((month == 2) || (month == 3) && (day <= 20)) {
            return getString(R.string.pisces)
        } else if((month == 3) || (month == 4) && (day <= 19)) {
            return getString(R.string.aries)
        } else if((month == 4) || (month == 5) && (day <= 21)) {
            return getString(R.string.taurus)
        } else if((month == 5) || (month == 6) && (day <= 21)) {
            return getString(R.string.gemini)
        } else if((month == 6) || (month == 7) && (day <= 23)) {
            return getString(R.string.cancer)
        } else if((month == 7) || (month == 8) && (day <= 23)) {
            return getString(R.string.leo)
        } else if((month == 8) || (month == 9) && (day <= 23)) {
            return getString(R.string.virgo)
        } else if((month == 9) || (month == 10) && (day <= 23)) {
            return getString(R.string.libra)
        } else if((month == 10) || (month == 11) && (day <= 22)) {
            return getString(R.string.scorpio)
        } else if(month == 12) {
            return getString(R.string.sagittarius)
        }
        return getString(R.string.no_data)
    }

    private fun init() {
        viewModel = ViewModelProvider(this, profileViewModelFactory)[ProfileViewModel::class]
        viewModel.checkAuth()
        nickname = binding.nickname
        vk = binding.vk
        inst = binding.inst
        editProfile = binding.editProfile
        id = binding.id
        phone = binding.phone
        city = binding.city
        birthday = binding.birthday
        horoscope = binding.horoscope
        logout = binding.logout
        binding.progressIndicator.visibility = View.VISIBLE
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