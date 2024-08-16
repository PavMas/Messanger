package com.trifcdr.data.di

import android.content.Context
import com.trifcdr.data.repository.ApiServiceRepositoryImpl
import com.trifcdr.data.repository.AuthorizationRepositoryImpl
import com.trifcdr.data.repository.ProfileRepositoryImpl
import com.trifcdr.data.repository.RegistrationRepositoryImpl
import com.trifcdr.domain.repository.AuthorizationRepository
import com.trifcdr.domain.repository.ProfileRepository
import com.trifcdr.domain.repository.RegistrationRepository
import com.trifcdr.network.repository.ApiServiceRepository
import com.trifcdr.network.retrofit.PlannerokApi
import com.trifcdr.storage.AppStorage
import com.trifcdr.storage.AppStorageImpl
import dagger.Module
import dagger.Provides

/**
 * Created by trifcdr.
 */

@Module
class DataModule {


    @Provides
    fun provideAuthorizationApi() = PlannerokApi.getInstance()

    @Provides
    fun provideAuthorizationRepository(plannerokApi: PlannerokApi,
                                       appStorage: AppStorage
    ): AuthorizationRepository {
        return AuthorizationRepositoryImpl(
            plannerokApi,
            appStorage
        )
    }


    @Provides
    fun provideRegistrationRepository(plannerokApi: PlannerokApi,
                                      appStorage: AppStorage
    ): RegistrationRepository {
        return RegistrationRepositoryImpl(
            plannerokApi,
            appStorage
        )
    }

    @Provides
    fun provideProfileRepository(plannerokApi: PlannerokApi,
                                 appStorage: AppStorage,
                                 serviceApi: ApiServiceRepository
    ): ProfileRepository {
        return ProfileRepositoryImpl(
            plannerokApi,
            appStorage,
            serviceApi
        )
    }


    @Provides
    fun provideApiServiceRepository(plannerokApi: PlannerokApi): ApiServiceRepository{
        return ApiServiceRepositoryImpl(
            plannerokApi
        )
    }

    @Provides
    fun provideAppStorage(context: Context): AppStorage = AppStorageImpl(context)
}