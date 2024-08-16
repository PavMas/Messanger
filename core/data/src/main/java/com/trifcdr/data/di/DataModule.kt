package com.trifcdr.data.di

import com.trifcdr.data.repository.ApiServiceRepositoryImpl
import com.trifcdr.network.repository.ApiServiceRepository
import com.trifcdr.network.retrofit.PlannerokApi
import dagger.Module
import dagger.Provides

/**
 * Created by trifcdr.
 */

@Module
class DataModule {

    @Provides
    fun provideApiServiceRepository(): ApiServiceRepository{
        return ApiServiceRepositoryImpl(
            PlannerokApi.getInstance()
        )
    }
}