package com.trifcdr.authorization.di

import com.trifcdr.di.BaseComponentHolder

object AuthorizationComponentHolder: BaseComponentHolder<
        AuthorizationApi,
        AuthorizationDependencies
        >() {
    override fun build(dependencies: AuthorizationDependencies): AuthorizationApi =
        DaggerAuthorizationComponent.factory().create(dependencies)
}