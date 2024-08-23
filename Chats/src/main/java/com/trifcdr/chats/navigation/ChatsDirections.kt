package com.trifcdr.chats.navigation

/**
 * Created by trifcdr.
 */
sealed interface ChatsDirections {

    data object ToAuthorization : ChatsDirections

    data class ToDialog(val args: ChatsToDialogArgs): ChatsDirections

}