package com.trifcdr.authorization.di

import android.content.Context
import androidx.lifecycle.ViewModel
import com.trifcdr.data.di.DataModule
import dagger.BindsInstance
import dagger.Component


@Component(
    dependencies = [AuthorizationDependencies::class],
    modules = [ViewModelModule::class, DataModule::class]
)
interface AuthorizationComponent: AuthorizationApi {

    fun getMap(): Map<Class<*>, ViewModel>

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: AuthorizationDependencies,
        ): AuthorizationComponent
    }
}