package com.trifcdr.messanger.navigation

import com.trifcdr.authorization.navigation.AuthorizationDirections

/**
 * Created by trifcdr.
 */
sealed interface AppDirections {

    object ToRegistration : AppDirections

}