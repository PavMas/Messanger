package com.trifcdr.authorization.navigation

import com.trifcdr.navigationapi.NavigationApi

sealed interface AuthorizationDirections {

    data object ToChats : AuthorizationDirections

    data class ToCodeCheck(val args: SendCodeToCheckArgs) : AuthorizationDirections

    data class ToRegistration(val args: CheckCodeToRegistrationArgs): AuthorizationDirections

    data object ToProfile: AuthorizationDirections


}