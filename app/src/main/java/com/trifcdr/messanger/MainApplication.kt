package com.trifcdr.messanger

import android.app.Application
import com.trifcdr.messanger.di.AppComponent
import com.trifcdr.messanger.di.ComponentHolderInitializer
import com.trifcdr.messanger.di.DaggerAppComponent
import com.trifcdr.navigationimpl.NavigationActivityProvider
import javax.inject.Inject

class MainApplication: Application() {

    @Inject
    lateinit var componentHolderInitializer: ComponentHolderInitializer

    private val appComponent: AppComponent get() = DaggerAppComponent.factory().create(
        context = this,
        activityProvider = NavigationActivityProvider(this),
    )

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)
        componentHolderInitializer.init()
        //val networkComponent = DaggerNetworkModuleComponent
    }
}