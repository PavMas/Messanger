package com.trifcdr.registration.di

import androidx.lifecycle.ViewModel
import com.trifcdr.registration.viewmodel.RegistrationViewModel
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
    @ClassKey(RegistrationViewModel::class)
    @IntoMap
    abstract fun registrationViewModel(registrationViewModel: RegistrationViewModel): ViewModel

}