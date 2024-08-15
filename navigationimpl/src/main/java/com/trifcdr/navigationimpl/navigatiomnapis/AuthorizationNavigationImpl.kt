package com.trifcdr.navigationimpl.navigatiomnapis

import androidx.navigation.NavController
import com.trifcdr.authorization.fragment.SendCodeFragmentDirections
import com.trifcdr.authorization.navigation.AuthorizationDirections
import com.trifcdr.authorization.navigation.CheckCodeArgs
import com.trifcdr.authorization.navigation.SendCodeToCheckArgs
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
                    SendCodeFragmentDirections.fromAuthToRegister()
                )
            }
            AuthorizationDirections.ToChats -> {
                navController.get().navigate(
                    SendCodeFragmentDirections.fromAuthToChats()
                )
            }
            is AuthorizationDirections.ToCodeCheck -> {
                navController.get().navigate(
                    SendCodeFragmentDirections.fromAuthToCode(
                        phone = direction.args.toCheckCodeArgs()
                    )
                )
            }
        }
    }

    companion object {
        private fun SendCodeToCheckArgs.toCheckCodeArgs(): CheckCodeArgs = CheckCodeArgs(
            phone = phone
        )
    }
}