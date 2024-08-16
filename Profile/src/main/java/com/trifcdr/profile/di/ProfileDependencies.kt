package com.trifcdr.profile.di

import android.content.Context
import com.trifcdr.di.BaseDependencies
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.profile.navigation.ProfileDirections

/**
 * Created by trifcdr.
 */
interface ProfileDependencies : BaseDependencies {

    val navigationApi: NavigationApi<ProfileDirections>

    val context: Context

}
