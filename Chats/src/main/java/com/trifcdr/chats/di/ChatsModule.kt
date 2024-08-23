package com.trifcdr.chats.di

import com.trifcdr.chats.recycler.holders.ChatsHolder
import com.trifcdr.chats.recycler.holders.CompanionMessageHolder
import com.trifcdr.chats.recycler.holders.MessageHolder
import com.trifcdr.chats.recycler.managers.ViewHoldersManager
import com.trifcdr.chats.recycler.managers.ViewHoldersManagerImpl
import com.trifcdr.chats.recycler.types.ItemTypes
import dagger.Module
import dagger.Provides


@Module
class ChatsModule {

    @Provides
    fun provideAdaptersManager(): ViewHoldersManager = ViewHoldersManagerImpl().apply {
        registerViewHolder(ItemTypes.CHAT, ChatsHolder())
        registerViewHolder(ItemTypes.USERS_MESSAGE, MessageHolder())
        registerViewHolder(ItemTypes.COMPANION_MESSAGE, CompanionMessageHolder())
    }
}