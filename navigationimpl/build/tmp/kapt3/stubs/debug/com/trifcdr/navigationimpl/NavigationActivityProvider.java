package com.trifcdr.navigationimpl;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/trifcdr/navigationimpl/NavigationActivityProvider;", "", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "activityReference", "Ljava/lang/ref/WeakReference;", "Lcom/trifcdr/navigationimpl/NavigationActivity;", "get", "registerActivityCallbacks", "", "navigationimpl_debug"})
public final class NavigationActivityProvider {
    @org.jetbrains.annotations.Nullable
    private java.lang.ref.WeakReference<com.trifcdr.navigationimpl.NavigationActivity> activityReference;
    
    public NavigationActivityProvider(@org.jetbrains.annotations.NotNull
    android.app.Application application) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable
    public final com.trifcdr.navigationimpl.NavigationActivity get() {
        return null;
    }
    
    private final void registerActivityCallbacks(android.app.Application application) {
    }
}