package com.trifcdr.navigationimpl.navigatiomnapis

import androidx.navigation.NavController
import com.trifcdr.authorization.fragment.AuthCodeFragmentDirections
import com.trifcdr.authorization.fragment.SendCodeFragmentDirections
import com.trifcdr.authorization.navigation.AuthorizationDirections
import com.trifcdr.authorization.navigation.CheckCodeArgs
import com.trifcdr.authorization.navigation.CheckCodeToRegistrationArgs
import com.trifcdr.authorization.navigation.SendCodeToCheckArgs
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.registration.navigation.RegistrationArgs
import javax.inject.Inject
import javax.inject.Provider

class AuthorizationNavigationImpl @Inject constructor(
    private val navController: Provider<NavController>,
): NavigationApi<AuthorizationDirections> {

    override fun navigate(direction: AuthorizationDirections) {
        when (direction) {
            is AuthorizationDirections.ToRegistration -> {
                navController.get().navigate(
                    AuthCodeFragmentDirections.fromAuthToRegister(
                        phone = direction.args.toRegistrationArgs()
                    )
                )
            }
            is AuthorizationDirections.ToChats -> {
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

        private fun CheckCodeToRegistrationArgs.toRegistrationArgs(): RegistrationArgs = RegistrationArgs(
            phone = phone
        )
    }
}