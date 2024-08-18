package com.trifcdr.navigationimpl.navigatiomnapis

import androidx.navigation.NavController
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.profile.fragment.ProfileEditFragmentDirections
import com.trifcdr.profile.fragment.ProfileFragmentDirections
import com.trifcdr.profile.navigation.ProfileDirections
import com.trifcdr.profile.navigation.ProfileEditArgs
import com.trifcdr.profile.navigation.ProfileToEditArgs
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by trifcdr.
 */
class ProfileNavigationImpl @Inject constructor(
    private val navController: Provider<NavController>,
) : NavigationApi<ProfileDirections> {

    override fun navigate(direction: ProfileDirections) {
        when (direction) {
            is ProfileDirections.ToProfileEdit -> {
                navController.get().navigate(
                    ProfileFragmentDirections.fromProfileToProfileEdit(
                        profileData = direction.profileEditArgs.toProfileEditArgs()
                    )
                )
            }

            is ProfileDirections.ToProfile -> {
                navController.get().navigate(
                    ProfileEditFragmentDirections.fromProfileEditToProfile()
                )
            }
        }
    }

    companion object {
        private fun ProfileToEditArgs.toProfileEditArgs(): ProfileEditArgs = ProfileEditArgs(
            id = id,
            phone = phone,
            name = name,
            username = username,
            birthday = birthday,
            city = city,
            vk = vk,
            instagram = instagram,
            status = status,
            avatar = avatar
        )
    }

}