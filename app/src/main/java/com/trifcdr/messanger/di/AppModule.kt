package com.trifcdr.messanger.di

import android.content.Context
import com.trifcdr.authorization.di.AuthorizationDependencies
import com.trifcdr.authorization.navigation.AuthorizationDirections
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.navigationimpl.NavigationActivityProvider
import com.trifcdr.navigationimpl.di.NavigationComponentHolderImpl
import com.trifcdr.navigationimpl.di.NavigationDependenciesImpl
import com.trifcdr.profile.di.ProfileDependencies
import com.trifcdr.profile.navigation.ProfileDirections
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
    fun provideAuthorizationDependencies(context: Context): AuthorizationDependencies =
        object : AuthorizationDependencies {
            override val navigationApi: NavigationApi<AuthorizationDirections> =
                NavigationComponentHolderImpl.get().authorizationNavigationApi
            override val context: Context = context
        }

    @Provides
    fun provideRegistrationDependencies(context: Context): RegistrationDependencies =
        object : RegistrationDependencies {
            override val navigationApi: NavigationApi<RegistrationDirections> =
                NavigationComponentHolderImpl.get().registrationNavigationApi
            override val context: Context = context
        }
    @Provides
    fun provideProfileDependencies(context: Context): ProfileDependencies =
        object : ProfileDependencies {
            override val navigationApi: NavigationApi<ProfileDirections> =
                NavigationComponentHolderImpl.get().profileNavigationApi
            override val context: Context = context
        }
}