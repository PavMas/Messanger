package com.trifcdr.navigationimpl.navigatiomnapis

import androidx.navigation.NavController
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.profile.navigation.ProfileDirections
import com.trifcdr.registration.navigation.RegistrationDirections
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by trifcdr.
 */
class ProfileNavigationImpl @Inject constructor(
    private val navController: Provider<NavController>,
): NavigationApi<ProfileDirections> {

    override fun navigate(direction: ProfileDirections) {
        when (direction) {

        }
    }

}