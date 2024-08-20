package com.trifcdr.chats.di

import androidx.lifecycle.ViewModel
import com.trifcdr.chats.viewmodel.ChatsViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap


@Module
abstract class ViewModelModule {


    @Binds
    @ClassKey(ChatsViewModel::class)
    @IntoMap
    abstract fun  chatsViewModel(mainViewModel: ChatsViewModel): ViewModel
}