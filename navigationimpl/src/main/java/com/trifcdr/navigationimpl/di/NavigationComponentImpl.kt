package com.trifcdr.navigationimpl.di

import dagger.Component


@Component(
    modules = [NavigationModuleImpl::class],
    dependencies = [NavigationDependenciesImpl::class],
)
interface NavigationComponentImpl: NavigationApiImpl
{
    @Component.Factory
    interface Factory {
        fun create(
            dependencies: NavigationDependenciesImpl,
        ): NavigationComponentImpl
    }
}