package com.trifcdr.registration.di

import com.trifcdr.di.BaseComponentHolder

/**
 * Created by trifcdr.
 */
object RegistrationComponentHolder: BaseComponentHolder<
        RegistrationApi,
        RegistrationDependencies>() {
    override fun build(dependencies: RegistrationDependencies): RegistrationApi =
        DaggerRegistrationComponent.factory().create(dependencies)
}