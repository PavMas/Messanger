package com.trifcdr.registration.di

import com.trifcdr.di.BaseApi
import com.trifcdr.registration.fragment.RegistrationFragment

/**
 * Created by trifcdr.
 */
interface RegistrationApi: BaseApi
{

    fun inject(fragment: RegistrationFragment)

}