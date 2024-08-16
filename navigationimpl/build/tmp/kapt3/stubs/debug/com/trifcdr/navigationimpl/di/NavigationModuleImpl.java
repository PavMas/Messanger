package com.trifcdr.navigationimpl.di;

import androidx.navigation.NavController;
import com.trifcdr.authorization.navigation.AuthorizationDirections;
import com.trifcdr.navigationapi.NavigationApi;
import com.trifcdr.navigationimpl.NavigationActivityProvider;
import com.trifcdr.navigationimpl.navigatiomnapis.AuthorizationNavigationImpl;
import com.trifcdr.navigationimpl.navigatiomnapis.ProfileNavigationImpl;
import com.trifcdr.navigationimpl.navigatiomnapis.RegistrationNavigationImpl;
import com.trifcdr.profile.navigation.ProfileDirections;
import com.trifcdr.registration.navigation.RegistrationDirections;
import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@dagger.Module(includes = {com.trifcdr.navigationimpl.di.NavigationModuleImpl.Binder.class})
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u00a8\u0006\b"}, d2 = {"Lcom/trifcdr/navigationimpl/di/NavigationModuleImpl;", "", "()V", "provideNavController", "Landroidx/navigation/NavController;", "activityProvider", "Lcom/trifcdr/navigationimpl/NavigationActivityProvider;", "Binder", "navigationimpl_debug"})
public final class NavigationModuleImpl {
    
    public NavigationModuleImpl() {
        super();
    }
    
    @dagger.Provides
    @org.jetbrains.annotations.NotNull
    public final androidx.navigation.NavController provideNavController(@org.jetbrains.annotations.NotNull
    com.trifcdr.navigationimpl.NavigationActivityProvider activityProvider) {
        return null;
    }
    
    @dagger.Module
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00032\u0006\u0010\u0005\u001a\u00020\tH\'J\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00032\u0006\u0010\u0005\u001a\u00020\fH\'\u00a8\u0006\r"}, d2 = {"Lcom/trifcdr/navigationimpl/di/NavigationModuleImpl$Binder;", "", "bindAuthorizationNavigationApi", "Lcom/trifcdr/navigationapi/NavigationApi;", "Lcom/trifcdr/authorization/navigation/AuthorizationDirections;", "api", "Lcom/trifcdr/navigationimpl/navigatiomnapis/AuthorizationNavigationImpl;", "bindProfileNavigationApi", "Lcom/trifcdr/profile/navigation/ProfileDirections;", "Lcom/trifcdr/navigationimpl/navigatiomnapis/ProfileNavigationImpl;", "bindRegistrationNavigationApi", "Lcom/trifcdr/registration/navigation/RegistrationDirections;", "Lcom/trifcdr/navigationimpl/navigatiomnapis/RegistrationNavigationImpl;", "navigationimpl_debug"})
    public static abstract interface Binder {
        
        @dagger.Binds
        @org.jetbrains.annotations.NotNull
        public abstract com.trifcdr.navigationapi.NavigationApi<com.trifcdr.authorization.navigation.AuthorizationDirections> bindAuthorizationNavigationApi(@org.jetbrains.annotations.NotNull
        com.trifcdr.navigationimpl.navigatiomnapis.AuthorizationNavigationImpl api);
        
        @dagger.Binds
        @org.jetbrains.annotations.NotNull
        public abstract com.trifcdr.navigationapi.NavigationApi<com.trifcdr.registration.navigation.RegistrationDirections> bindRegistrationNavigationApi(@org.jetbrains.annotations.NotNull
        com.trifcdr.navigationimpl.navigatiomnapis.RegistrationNavigationImpl api);
        
        @dagger.Binds
        @org.jetbrains.annotations.NotNull
        public abstract com.trifcdr.navigationapi.NavigationApi<com.trifcdr.profile.navigation.ProfileDirections> bindProfileNavigationApi(@org.jetbrains.annotations.NotNull
        com.trifcdr.navigationimpl.navigatiomnapis.ProfileNavigationImpl api);
    }
}