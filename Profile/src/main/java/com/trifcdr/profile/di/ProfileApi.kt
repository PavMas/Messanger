package com.trifcdr.profile.di

import com.trifcdr.di.BaseApi
import com.trifcdr.profile.ProfileFragment

/**
 * Created by trifcdr.
 */
interface ProfileApi: BaseApi {

    fun inject(fragment: ProfileFragment)

}