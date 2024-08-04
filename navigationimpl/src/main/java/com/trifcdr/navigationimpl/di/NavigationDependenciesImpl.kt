package com.trifcdr.navigationimpl.di

import com.trifcdr.di.BaseDependencies
import com.trifcdr.navigationimpl.NavigationActivityProvider

interface NavigationDependenciesImpl: BaseDependencies {

    val activityProvider: NavigationActivityProvider

}