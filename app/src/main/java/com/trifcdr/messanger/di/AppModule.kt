package com.trifcdr.messanger.di

import com.trifcdr.authorization.di.AuthorizationDependencies
import com.trifcdr.authorization.navigation.AuthorizationDirections
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.navigationimpl.NavigationActivityProvider
import com.trifcdr.navigationimpl.di.NavigationComponentHolderImpl
import com.trifcdr.navigationimpl.di.NavigationDependenciesImpl
import com.trifcdr.registration.di.RegistrationDependencies
import com.trifcdr.registration.navigation.RegistrationDirections
import dagger.Module
import dagger.Provides


@Module
internal class AppModule {

    @Provides
    fun provideNavigationDependencies(
        activityProvider: NavigationActivityProvider,
    ): NavigationDependenciesImpl = object : NavigationDependenciesImpl {
        override val activityProvider: NavigationActivityProvider = activityProvider
    }

    @Provides
    fun provideAuthorizationDependencies(): AuthorizationDependencies =
        object : AuthorizationDependencies {
            override val navigationApi: NavigationApi<AuthorizationDirections> =
                NavigationComponentHolderImpl.get().authorizationNavigationApi
        }

    @Provides
    fun provideRegistrationDependencies(): RegistrationDependencies =
        object : RegistrationDependencies {
            override val navigationApi: NavigationApi<RegistrationDirections> =
                NavigationComponentHolderImpl.get().registrationNavigationApi
        }
//
//    @Provides
//    fun provideFeature3Dependencies(): Feature3Dependencies =
//        object : Feature3Dependencies {
//            override val navigationApi: NavigationApi<Feature3Directions> =
//                NavigationImplComponentHolder.get().feature3NavigationApi
//        }
}