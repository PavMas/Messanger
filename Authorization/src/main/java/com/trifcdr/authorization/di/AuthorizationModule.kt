package com.trifcdr.authorization.di

import com.trifcdr.common.di.DaggerNetworkModuleComponent
import com.trifcdr.data.repository.AuthorizationRepositoryImpl
import com.trifcdr.domain.repository.AuthorizationRepository
import com.trifcdr.network.model.Network
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Inject

/**
 * Created by trifcdr.
 */

@Module
class AuthorizationModule {

    @Provides
    fun provideAuthorizationRepository(): AuthorizationRepository {
        return AuthorizationRepositoryImpl(
            DaggerNetworkModuleComponent.create().provideNetwork().getRetrofit()
        )
    }
}