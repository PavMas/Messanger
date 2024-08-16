package com.trifcdr.navigationimpl.navigatiomnapis

import androidx.navigation.NavController
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.registration.fragment.RegistrationFragmentDirections
import com.trifcdr.registration.navigation.RegistrationDirections
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by trifcdr.
 */
internal class RegistrationNavigationImpl @Inject constructor(
    private val navController: Provider<NavController>,
): NavigationApi<RegistrationDirections> {

    override fun navigate(direction: RegistrationDirections) {
        when (direction) {
//            is RegistrationDirections.ToAuthorization -> {
//                navController.get().navigate(
//                    Feature2FragmentDirections.fromFeature2ToFeature3(
//                        args = direction.args.toFeature3Args(),
//                    )
//                )
//            }
            is RegistrationDirections.ToAuthorization -> {
                navController.get().navigate(
                    RegistrationFragmentDirections.fromRegisterToAuth()
                )
            }

            is RegistrationDirections.ToProfile -> {
                navController.get().navigate(
                    RegistrationFragmentDirections.fromRegisterToProfile()
                )
            }
        }
    }

//    companion object {
//        private fun Feature2To3Args.toFeature3Args(): Feature3Args = Feature3Args(
//            value = "$someArg2 : $someArg1"
//        )
//    }
}