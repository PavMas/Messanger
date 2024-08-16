package com.trifcdr.navigationimpl.di

import com.trifcdr.authorization.navigation.AuthorizationDirections
import com.trifcdr.di.BaseApi
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.profile.navigation.ProfileDirections
import com.trifcdr.registration.navigation.RegistrationDirections

interface NavigationApiImpl: BaseApi {

    val authorizationNavigationApi: NavigationApi<AuthorizationDirections>

    val registrationNavigationApi: NavigationApi<RegistrationDirections>

    val profileNavigationApi: NavigationApi<ProfileDirections>

}