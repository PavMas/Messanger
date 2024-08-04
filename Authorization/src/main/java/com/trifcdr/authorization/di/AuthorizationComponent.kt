package com.trifcdr.authorization.di

import dagger.Component


@Component(
    dependencies = [AuthorizationDependencies::class],
)
interface AuthorizationComponent: AuthorizationApi {
}