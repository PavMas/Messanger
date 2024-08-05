package com.trifcdr.navigationimpl.di;

import com.trifcdr.di.BaseDependencies;
import com.trifcdr.navigationimpl.NavigationActivityProvider;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005\u00a8\u0006\u0006"}, d2 = {"Lcom/trifcdr/navigationimpl/di/NavigationDependenciesImpl;", "Lcom/trifcdr/di/BaseDependencies;", "activityProvider", "Lcom/trifcdr/navigationimpl/NavigationActivityProvider;", "getActivityProvider", "()Lcom/trifcdr/navigationimpl/NavigationActivityProvider;", "navigationimpl_debug"})
public abstract interface NavigationDependenciesImpl extends com.trifcdr.di.BaseDependencies {
    
    @org.jetbrains.annotations.NotNull
    public abstract com.trifcdr.navigationimpl.NavigationActivityProvider getActivityProvider();
}