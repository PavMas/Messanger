package com.trifcdr.authorization.di

import androidx.lifecycle.ViewModel
import com.trifcdr.authorization.AuthorizationViewModel
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
    @ClassKey(AuthorizationViewModel::class)
    @IntoMap
    abstract fun  mainViewModel(mainViewModel: AuthorizationViewModel): ViewModel

}