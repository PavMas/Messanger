package com.trifcdr.profile.di

import androidx.lifecycle.ViewModel
import com.trifcdr.data.di.DataModule
import dagger.Component

/**
 * Created by trifcdr.
 */

@Component(
    dependencies = [ProfileDependencies::class],
    modules = [ViewModelModule::class, DataModule::class]
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