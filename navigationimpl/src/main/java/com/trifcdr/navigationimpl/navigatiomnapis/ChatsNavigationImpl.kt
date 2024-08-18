package com.trifcdr.navigationimpl.navigatiomnapis

import androidx.navigation.NavController
import com.trifcdr.chats.ChatsFragmentDirections
import com.trifcdr.chats.navigation.ChatsDirections
import com.trifcdr.navigationapi.NavigationApi
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by trifcdr.
 */
class ChatsNavigationImpl @Inject constructor(
    private val navController: Provider<NavController>,
) : NavigationApi<ChatsDirections> {

    override fun navigate(direction: ChatsDirections) {
        when (direction) {
            is ChatsDirections.ToAuthorization -> {
                navController.get().navigate(
                    ChatsFragmentDirections.fromChatsToAuth()
                )
            }
        }
    }

}