package com.trifcdr.authorization.di

import androidx.lifecycle.ViewModel
import com.trifcdr.data.repository.AuthorizationRepositoryImpl
import com.trifcdr.domain.repository.AuthorizationRepository
import dagger.Component
import dagger.Provides
import retrofit2.Retrofit


@Component(
    dependencies = [AuthorizationDependencies::class],
    modules = [ViewModelModule::class, AuthorizationModule::class]
)
interface AuthorizationComponent: AuthorizationApi {

    fun getMap(): Map<Class<*>, ViewModel>

    @Component.Factory
    interface Factory {
        fun create(
            dependencies: AuthorizationDependencies
        ): AuthorizationComponent
    }
}