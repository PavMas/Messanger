package com.trifcdr.chats.di

import com.trifcdr.chats.fragment.ChatsFragment
import com.trifcdr.di.BaseApi

/**
 * Created by trifcdr.
 */


interface ChatsApi: BaseApi {

    fun inject(fragment: ChatsFragment)

}