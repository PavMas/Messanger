package com.trifcdr.registration.di

import androidx.lifecycle.ViewModel
import com.trifcdr.common.di.CommonModule
import dagger.Component

/**
 * Created by trifcdr.
 */

@Component(
    dependencies = [RegistrationDependencies::class],
    modules = [CommonModule::class, ViewModelModule::class]
)

interface RegistrationComponent: RegistrationApi {

    fun getMap(): Map<Class<*>, ViewModel>


    @Component.Factory
    interface Factory {
        fun create(
            dependencies: RegistrationDependencies,
        ): RegistrationComponent
    }
}