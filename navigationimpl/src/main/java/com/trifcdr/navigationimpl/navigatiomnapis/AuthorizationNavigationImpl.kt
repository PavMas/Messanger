package com.trifcdr.navigationimpl.navigatiomnapis

import androidx.navigation.NavController
import com.trifcdr.authorization.AuthorizationFragmentDirections
import com.trifcdr.authorization.navigation.AuthorizationDirections
import com.trifcdr.navigationapi.NavigationApi
import javax.inject.Inject
import javax.inject.Provider

class AuthorizationNavigationImpl @Inject constructor(
    private val navController: Provider<NavController>,
): NavigationApi<AuthorizationDirections> {

    override fun navigate(direction: AuthorizationDirections) {
        when (direction) {
            AuthorizationDirections.ToRegistration -> {
                navController.get().navigate(
                    AuthorizationFragmentDirections.fromAuthToRegister()
                )
            }
            AuthorizationDirections.ToChats -> {
                navController.get().navigate(
                    AuthorizationFragmentDirections.fromAuthToChats()
                )
            }
        }
    }
}