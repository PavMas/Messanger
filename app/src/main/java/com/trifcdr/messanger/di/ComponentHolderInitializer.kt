package com.trifcdr.messanger.di

import android.content.Context
import com.trifcdr.authorization.di.AuthorizationComponentHolder
import com.trifcdr.authorization.di.AuthorizationDependencies
import com.trifcdr.chats.di.ChatsComponentHolder
import com.trifcdr.chats.di.ChatsDependencies
import com.trifcdr.navigationimpl.di.NavigationComponentHolderImpl
import com.trifcdr.navigationimpl.di.NavigationDependenciesImpl
import com.trifcdr.profile.di.ProfileComponent
import com.trifcdr.profile.di.ProfileComponentHolder
import com.trifcdr.profile.di.ProfileDependencies
import com.trifcdr.registration.di.RegistrationComponentHolder
import com.trifcdr.registration.di.RegistrationDependencies
import javax.inject.Inject
import javax.inject.Provider

class ComponentHolderInitializer @Inject constructor(
    private val navigationDependencies: Provider<NavigationDependenciesImpl>,
    private val authorizationDependencies: Provider<AuthorizationDependencies>,
    private val registrationDependencies: Provider<RegistrationDependencies>,
    private val profileDependencies: Provider<ProfileDependencies>,
    private val chatsDependencies: Provider<ChatsDependencies>,
) {

    fun init() {
        NavigationComponentHolderImpl.init(navigationDependencies)
        AuthorizationComponentHolder.init(authorizationDependencies)
        RegistrationComponentHolder.init(registrationDependencies)
        ProfileComponentHolder.init(profileDependencies)
        ChatsComponentHolder.init(chatsDependencies)
    }
}