package com.trifcdr.profile.di

import com.trifcdr.di.BaseApi
import com.trifcdr.profile.fragment.ProfileEditFragment
import com.trifcdr.profile.fragment.ProfileFragment

/**
 * Created by trifcdr.
 */
interface ProfileApi: BaseApi {

    fun inject(fragment: ProfileFragment)

    fun inject(fragment: ProfileEditFragment)

}