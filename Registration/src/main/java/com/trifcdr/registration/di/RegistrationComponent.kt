package com.trifcdr.registration.di

import dagger.Component

/**
 * Created by trifcdr.
 */

@Component(
    dependencies = [RegistrationDependencies::class],
    modules = [RegistrationModule::class, ViewModelModule::class]
)

interface RegistrationComponent: RegistrationApi {

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: RegistrationDependencies,
        ): RegistrationComponent
    }
}