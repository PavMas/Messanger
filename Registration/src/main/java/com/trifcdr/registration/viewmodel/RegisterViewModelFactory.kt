package com.trifcdr.registration.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

/**
 * Created by trifcdr.
 */
class RegisterViewModelFactory @Inject constructor(private val map: Map<Class<*>, @JvmSuppressWildcards ViewModel>) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return map[modelClass] as T
    }
}