package com.trifcdr.common.di

import com.trifcdr.network.di.NetworkModule
import com.trifcdr.network.model.Network
import dagger.Component


@Component(modules = [NetworkModule::class])
interface NetworkModuleComponent {

    fun provideNetwork(): Network
}