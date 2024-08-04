package com.trifcdr.navigationimpl.di

import com.trifcdr.authorization.navigation.AuthorizationDirections
import com.trifcdr.di.BaseApi
import com.trifcdr.navigationapi.NavigationApi

interface NavigationApiImpl: BaseApi {

    val authorizationNavigationApi: NavigationApi<AuthorizationDirections>

}