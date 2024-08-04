package com.trifcdr.navigationimpl.di

import com.trifcdr.di.BaseComponentHolder

object NavigationComponentHolderImpl: BaseComponentHolder<
        NavigationApiImpl,
        NavigationDependenciesImpl
        >() {
    override fun build(dependencies: NavigationDependenciesImpl): NavigationApiImpl =
        DaggerNavigationComponentImpl.factory().create(dependencies)
}