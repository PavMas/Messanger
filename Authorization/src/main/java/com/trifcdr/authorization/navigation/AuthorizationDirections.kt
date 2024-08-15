package com.trifcdr.authorization.navigation

import com.trifcdr.navigationapi.NavigationApi

sealed interface AuthorizationDirections {

    data object ToRegistration : AuthorizationDirections

    data object ToChats : AuthorizationDirections

    data class ToCodeCheck(val args: SendCodeToCheckArgs) : AuthorizationDirections


}