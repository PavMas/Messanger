package com.trifcdr.authorization.di

import androidx.lifecycle.ViewModel
import com.trifcdr.authorization.AuthorizationFragment
import com.trifcdr.di.BaseApi

interface AuthorizationApi: BaseApi {

    fun inject(fragment: AuthorizationFragment)




}