package com.trifcdr.chats.di

import com.trifcdr.di.BaseComponentHolder

/**
 * Created by trifcdr.
 */
object ChatsComponentHolder : BaseComponentHolder<
        ChatsApi,
        ChatsDependencies,
        >() {

    override fun build(dependencies: ChatsDependencies): ChatsApi =
        DaggerChatsComponent.factory().create(dependencies)
}