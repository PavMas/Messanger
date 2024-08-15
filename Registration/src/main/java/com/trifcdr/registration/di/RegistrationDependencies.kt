package com.trifcdr.registration.di

import android.content.Context
import com.trifcdr.di.BaseDependencies
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.registration.navigation.RegistrationDirections

/**
 * Created by trifcdr.
 */
interface RegistrationDependencies: BaseDependencies {

    val navigationApi: NavigationApi<RegistrationDirections>

    val context: Context

}