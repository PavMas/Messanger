package com.trifcdr.profile.di

import androidx.lifecycle.ViewModel
import com.trifcdr.profile.viewmodel.ProfileViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

/**
 * Created by trifcdr.
 */

@Module
abstract class ViewModelModule {

    @Binds
    @ClassKey(ProfileViewModel::class)
    @IntoMap
    abstract fun  profileViewModel(mainViewModel: ProfileViewModel): ViewModel

}