package com.trifcdr.network.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by trifcdr.
 */

@Module
class NetworkModule {

    @Provides
    fun provideOkHttp(): OkHttpClient{
        return OkHttpClient().newBuilder()
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    @Provides
    fun provideGson(): Gson{
        return Gson()
    }

    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create(gson))
            .baseUrl("https://plannerok.ru/")
            .client(okHttpClient)
            .build()
    }
}