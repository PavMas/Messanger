package com.trifcdr.authorization.di

import com.trifcdr.authorization.navigation.AuthorizationDirections
import com.trifcdr.di.BaseDependencies
import com.trifcdr.navigationapi.NavigationApi

interface AuthorizationDependencies: BaseDependencies {

    val navigationApi: NavigationApi<AuthorizationDirections>


}