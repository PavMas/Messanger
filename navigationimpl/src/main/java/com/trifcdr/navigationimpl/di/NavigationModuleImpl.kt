package com.trifcdr.navigationimpl.di

import androidx.navigation.NavController
import com.trifcdr.authorization.navigation.AuthorizationDirections
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.navigationimpl.NavigationActivityProvider
import com.trifcdr.navigationimpl.navigatiomnapis.AuthorizationNavigationImpl
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

//        @Binds
//        fun bindFeature2NavigationApi(api: Feature2NavigationImpl): NavigationApi<Feature2Directions>
//
//        @Binds
//        fun bindFeature3NavigationApi(api: Feature3NavigationImpl): NavigationApi<Feature3Directions>
    }
}