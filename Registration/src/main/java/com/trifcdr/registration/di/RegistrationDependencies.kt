package com.trifcdr.registration.di

import com.trifcdr.di.BaseDependencies
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.registration.navigation.RegistrationDirections

/**
 * Created by trifcdr.
 */
interface RegistrationDependencies: BaseDependencies {

    val navigationApi: NavigationApi<RegistrationDirections>

}