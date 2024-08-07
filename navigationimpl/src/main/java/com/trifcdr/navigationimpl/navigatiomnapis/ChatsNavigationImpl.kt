package com.trifcdr.navigationimpl.navigatiomnapis

import androidx.navigation.NavController
import com.trifcdr.chats.ChatsFragmentDirections
import com.trifcdr.chats.navigation.ChatsDirections
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.registration.RegistrationFragmentDirections
import com.trifcdr.registration.navigation.RegistrationDirections
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by trifcdr.
 */
class ChatsNavigationImpl @Inject constructor(
    private val navController: Provider<NavController>,
): NavigationApi<ChatsDirections> {

    override fun navigate(direction: ChatsDirections) {
        when (direction) {
//            is RegistrationDirections.ToAuthorization -> {
//                navController.get().navigate(
//                    Feature2FragmentDirections.fromFeature2ToFeature3(
//                        args = direction.args.toFeature3Args(),
//                    )
//                )
//            }
            is ChatsDirections.ToAuthorization -> {
                navController.get().navigate(
                    ChatsFragmentDirections.fromChatsToAuth()
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