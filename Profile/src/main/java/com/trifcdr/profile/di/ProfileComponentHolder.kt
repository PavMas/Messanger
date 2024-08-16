package com.trifcdr.profile.di

import com.trifcdr.di.BaseComponentHolder

/**
 * Created by trifcdr.
 */
object ProfileComponentHolder : BaseComponentHolder<
        ProfileApi,
        ProfileDependencies
        >() {

    override fun build(dependencies: ProfileDependencies): ProfileApi =
        DaggerProfileComponent.factory().create(dependencies)
}
