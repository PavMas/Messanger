package com.trifcdr.chats.di

import android.content.Context
import com.trifcdr.chats.navigation.ChatsDirections
import com.trifcdr.di.BaseDependencies
import com.trifcdr.navigationapi.NavigationApi

/**
 * Created by trifcdr.
 */
interface ChatsDependencies: BaseDependencies{

    val navigationApi: NavigationApi<ChatsDirections>

    val context: Context

}