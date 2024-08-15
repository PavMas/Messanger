package com.trifcdr.authorization.di

import android.content.Context
import com.trifcdr.authorization.navigation.AuthorizationDirections
import com.trifcdr.di.BaseDependencies
import com.trifcdr.navigationapi.NavigationApi

interface AuthorizationDependencies: BaseDependencies {

    val navigationApi: NavigationApi<AuthorizationDirections>

    val context: Context


}