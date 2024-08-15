package com.trifcdr.authorization.di

import android.content.Context
import com.trifcdr.authorization.fragment.AuthCodeFragment
import com.trifcdr.authorization.fragment.SendCodeFragment
import com.trifcdr.di.BaseApi
import dagger.BindsInstance


interface AuthorizationApi: BaseApi {

    fun inject(fragment: SendCodeFragment)

    fun inject(fragment: AuthCodeFragment)

}