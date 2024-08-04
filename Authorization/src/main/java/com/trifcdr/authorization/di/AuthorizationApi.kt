package com.trifcdr.authorization.di

import com.trifcdr.authorization.AuthorizationFragment
import com.trifcdr.di.BaseApi

interface AuthorizationApi: BaseApi {

    fun inject(fragment: AuthorizationFragment)

}