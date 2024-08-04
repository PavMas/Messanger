package com.trifcdr.authorization.navigation

import com.trifcdr.navigationapi.NavigationApi

sealed interface AuthorizationDirections {
    object ToRegistration : AuthorizationDirections


}