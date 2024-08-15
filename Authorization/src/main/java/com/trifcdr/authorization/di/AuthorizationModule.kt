package com.trifcdr.authorization.di

import android.content.Context
import com.trifcdr.data.repository.AuthorizationRepositoryImpl
import com.trifcdr.domain.repository.AuthorizationRepository
import com.trifcdr.network.retrofit.PlannerokApi
import com.trifcdr.storage.AppStorage
import com.trifcdr.storage.AppStorageImpl
import dagger.Module
import dagger.Provides


/**
 * Created by trifcdr.
 */

@Module
class AuthorizationModule {


    @Provides
    fun provideAuthorizationRepository(plannerokApi: PlannerokApi,
                                       appStorage: AppStorage): AuthorizationRepository{
        return AuthorizationRepositoryImpl(
            plannerokApi,
            appStorage
        )
    }

    @Provides
    fun provideAuthorizationApi() = PlannerokApi.getInstance()

    @Provides
    fun provideAppStorage(context: Context): AppStorage = AppStorageImpl(context)



}