package com.trifcdr.profile.di

import androidx.lifecycle.ViewModel
import dagger.Component

/**
 * Created by trifcdr.
 */

@Component(
    dependencies = [ProfileDependencies::class],
    modules = [ViewModelModule::class, ProfileModule::class]
)
interface ProfileComponent: ProfileApi {

    fun getMap(): Map<Class<*>, ViewModel>

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: ProfileDependencies,
        ): ProfileComponent
    }
}