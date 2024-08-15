package com.trifcdr.messanger.di

import android.content.Context
import com.trifcdr.authorization.di.AuthorizationComponentHolder
import com.trifcdr.authorization.di.AuthorizationDependencies
import com.trifcdr.navigationimpl.di.NavigationComponentHolderImpl
import com.trifcdr.navigationimpl.di.NavigationDependenciesImpl
import com.trifcdr.registration.di.RegistrationComponentHolder
import com.trifcdr.registration.di.RegistrationDependencies
import javax.inject.Inject
import javax.inject.Provider

class ComponentHolderInitializer @Inject constructor(
    private val navigationDependencies: Provider<NavigationDependenciesImpl>,
    private val authorizationDependencies: Provider<AuthorizationDependencies>,
    private val registrationDependencies: Provider<RegistrationDependencies>,
) {

    fun init() {
        NavigationComponentHolderImpl.init(navigationDependencies)
        AuthorizationComponentHolder.init(authorizationDependencies)
        RegistrationComponentHolder.init(registrationDependencies)
    }
}