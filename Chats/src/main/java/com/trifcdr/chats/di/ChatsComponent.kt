package com.trifcdr.chats.di

import dagger.Component

/**
 * Created by trifcdr.
 */

@Component(
    dependencies = [ChatsDependencies::class]
)
interface ChatsComponent: ChatsApi {

    @Component.Factory
    interface Factory{
        fun create(
            dependencies: ChatsDependencies,
        ): ChatsComponent
    }

}