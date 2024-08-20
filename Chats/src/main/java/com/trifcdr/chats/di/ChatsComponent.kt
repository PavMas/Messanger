package com.trifcdr.chats.di

import com.trifcdr.chats.viewmodel.ChatsViewModel
import com.trifcdr.data.di.DataModule
import dagger.Component

/**
 * Created by trifcdr.
 */

@Component(
    dependencies = [ChatsDependencies::class],
    modules = [ViewModelModule::class, DataModule::class]
)
interface ChatsComponent: ChatsApi {

    @Component.Factory
    interface Factory{
        fun create(
            dependencies: ChatsDependencies,
        ): ChatsComponent
    }

}