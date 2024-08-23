package com.trifcdr.navigationimpl.navigatiomnapis

import androidx.navigation.NavController
import com.trifcdr.authorization.navigation.CheckCodeArgs
import com.trifcdr.authorization.navigation.CheckCodeToRegistrationArgs
import com.trifcdr.authorization.navigation.SendCodeToCheckArgs
import com.trifcdr.chats.fragment.ChatsFragmentDirections
import com.trifcdr.chats.fragment.DialogFragmentDirections
import com.trifcdr.chats.navigation.ChatsDirections
import com.trifcdr.chats.navigation.ChatsToDialogArgs
import com.trifcdr.chats.navigation.DialogArgs
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.registration.navigation.RegistrationArgs
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

            is ChatsDirections.ToDialog -> {
                navController.get().navigate(
                    ChatsFragmentDirections.fromChatsToDialog(
                        id = direction.args.toDialogArgs()
                    )
                )
            }
        }
    }

    companion object {
        private fun ChatsToDialogArgs.toDialogArgs(): DialogArgs = DialogArgs(
            dialogId = dialogId
        )
    }

}