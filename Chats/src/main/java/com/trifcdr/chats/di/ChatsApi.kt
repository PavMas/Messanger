package com.trifcdr.chats.di

import com.trifcdr.chats.ChatsFragment
import com.trifcdr.di.BaseApi
import dagger.Component

/**
 * Created by trifcdr.
 */


interface ChatsApi: BaseApi {

    fun inject(fragment: ChatsFragment)

}