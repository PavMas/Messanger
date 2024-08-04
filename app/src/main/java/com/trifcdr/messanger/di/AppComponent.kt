package com.trifcdr.messanger.di

import com.trifcdr.messanger.MainApplication
import com.trifcdr.navigationimpl.NavigationActivityProvider
import dagger.BindsInstance
import dagger.Component


@Component(
    modules = [AppModule::class],
)
internal interface AppComponent {

    fun inject(app: MainApplication)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activityProvider: NavigationActivityProvider,
        ): AppComponent
    }
}