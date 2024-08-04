package com.trifcdr.messanger.di

import com.trifcdr.authorization.di.AuthorizationComponentHolder
import com.trifcdr.authorization.di.AuthorizationDependencies
import com.trifcdr.navigationimpl.di.NavigationComponentHolderImpl
import com.trifcdr.navigationimpl.di.NavigationDependenciesImpl
import javax.inject.Inject
import javax.inject.Provider

internal class ComponentHolderInitializer @Inject constructor(
    private val navigationDependencies: Provider<NavigationDependenciesImpl>,
    private val authorizationDependencies: Provider<AuthorizationDependencies>,
//    private val feature2Dependencies: Provider<Feature2Dependencies>,
//    private val feature3Dependencies: Provider<Feature3Dependencies>
) {

    fun init() {
        NavigationComponentHolderImpl.init(navigationDependencies)
        AuthorizationComponentHolder.init(authorizationDependencies)
//        Feature2ComponentHolder.init(feature2Dependencies)
//        Feature3ComponentHolder.init(feature3Dependencies)
    }
}