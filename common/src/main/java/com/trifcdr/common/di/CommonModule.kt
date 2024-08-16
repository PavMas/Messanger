package com.trifcdr.common.di

import android.content.Context
import com.trifcdr.data.repository.AuthorizationRepositoryImpl
import com.trifcdr.data.repository.RegistrationRepositoryImpl
import com.trifcdr.domain.repository.AuthorizationRepository
import com.trifcdr.domain.repository.RegistrationRepository
import com.trifcdr.network.retrofit.PlannerokApi
import com.trifcdr.storage.AppStorage
import com.trifcdr.storage.AppStorageImpl
import dagger.Module
import dagger.Provides

/**
 * Created by trifcdr.
 */

@Module
class CommonModule {

    @Provides
    fun provideAuthorizationApi() = PlannerokApi.getInstance()

    @Provides
    fun provideAuthorizationRepository(plannerokApi: PlannerokApi,
                                   appStorage: AppStorage): AuthorizationRepository {
    return AuthorizationRepositoryImpl(
        plannerokApi,
        appStorage
        )
    }

    @Provides
    fun provideRegistrationRepository(plannerokApi: PlannerokApi,
                                      appStorage: AppStorage): RegistrationRepository {
        return RegistrationRepositoryImpl(
            plannerokApi,
            appStorage
        )
    }



    @Provides
    fun provideAppStorage(context: Context): AppStorage = AppStorageImpl(context)


}