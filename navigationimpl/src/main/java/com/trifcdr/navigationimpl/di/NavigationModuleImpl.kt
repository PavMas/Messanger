package com.trifcdr.navigationimpl.di

import androidx.navigation.NavController
import com.trifcdr.authorization.navigation.AuthorizationDirections
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.navigationimpl.NavigationActivityProvider
import com.trifcdr.navigationimpl.navigatiomnapis.AuthorizationNavigationImpl
import com.trifcdr.navigationimpl.navigatiomnapis.ProfileNavigationImpl
import com.trifcdr.navigationimpl.navigatiomnapis.RegistrationNavigationImpl
import com.trifcdr.profile.navigation.ProfileDirections
import com.trifcdr.registration.navigation.RegistrationDirections
import dagger.Binds
import dagger.Module
import dagger.Provides


@Module(
    includes = [NavigationModuleImpl.Binder::class],
)
internal class NavigationModuleImpl {

    @Provides
    fun provideNavController(
        activityProvider: NavigationActivityProvider,
    ): NavController = activityProvider.get()
        ?.getNavigationFragment()
        ?.navController
        ?: error("Do not make navigation calls while activity is not available")

    @Module
    interface Binder {

        @Binds
        fun bindAuthorizationNavigationApi(api: AuthorizationNavigationImpl): NavigationApi<AuthorizationDirections>

        @Binds
        fun bindRegistrationNavigationApi(api: RegistrationNavigationImpl): NavigationApi<RegistrationDirections>

        @Binds
        fun bindProfileNavigationApi(api: ProfileNavigationImpl): NavigationApi<ProfileDirections>
//
//        @Binds
//        fun bindFeature3NavigationApi(api: Feature3NavigationImpl): NavigationApi<Feature3Directions>
    }
}