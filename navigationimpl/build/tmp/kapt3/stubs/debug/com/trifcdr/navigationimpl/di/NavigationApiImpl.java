package com.trifcdr.navigationimpl.di;

import com.trifcdr.authorization.navigation.AuthorizationDirections;
import com.trifcdr.di.BaseApi;
import com.trifcdr.navigationapi.NavigationApi;
import com.trifcdr.registration.navigation.RegistrationDirections;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001R\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0003X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/trifcdr/navigationimpl/di/NavigationApiImpl;", "Lcom/trifcdr/di/BaseApi;", "authorizationNavigationApi", "Lcom/trifcdr/navigationapi/NavigationApi;", "Lcom/trifcdr/authorization/navigation/AuthorizationDirections;", "getAuthorizationNavigationApi", "()Lcom/trifcdr/navigationapi/NavigationApi;", "registrationNavigationApi", "Lcom/trifcdr/registration/navigation/RegistrationDirections;", "getRegistrationNavigationApi", "navigationimpl_debug"})
public abstract interface NavigationApiImpl extends com.trifcdr.di.BaseApi {
    
    @org.jetbrains.annotations.NotNull
    public abstract com.trifcdr.navigationapi.NavigationApi<com.trifcdr.authorization.navigation.AuthorizationDirections> getAuthorizationNavigationApi();
    
    @org.jetbrains.annotations.NotNull
    public abstract com.trifcdr.navigationapi.NavigationApi<com.trifcdr.registration.navigation.RegistrationDirections> getRegistrationNavigationApi();
}