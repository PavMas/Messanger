package com.trifcdr.navigationimpl.di;

import dagger.Component;

@dagger.Component(modules = {com.trifcdr.navigationimpl.di.NavigationModuleImpl.class}, dependencies = {com.trifcdr.navigationimpl.di.NavigationDependenciesImpl.class})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/trifcdr/navigationimpl/di/NavigationComponentImpl;", "Lcom/trifcdr/navigationimpl/di/NavigationApiImpl;", "Factory", "navigationimpl_debug"})
public abstract interface NavigationComponentImpl extends com.trifcdr.navigationimpl.di.NavigationApiImpl {
    
    @dagger.Component.Factory
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/trifcdr/navigationimpl/di/NavigationComponentImpl$Factory;", "", "create", "Lcom/trifcdr/navigationimpl/di/NavigationComponentImpl;", "dependencies", "Lcom/trifcdr/navigationimpl/di/NavigationDependenciesImpl;", "navigationimpl_debug"})
    public static abstract interface Factory {
        
        @org.jetbrains.annotations.NotNull
        public abstract com.trifcdr.navigationimpl.di.NavigationComponentImpl create(@org.jetbrains.annotations.NotNull
        com.trifcdr.navigationimpl.di.NavigationDependenciesImpl dependencies);
    }
}