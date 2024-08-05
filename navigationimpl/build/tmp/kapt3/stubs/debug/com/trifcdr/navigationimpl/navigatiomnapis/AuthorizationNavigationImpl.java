package com.trifcdr.navigationimpl.navigatiomnapis;

import androidx.navigation.NavController;
import com.trifcdr.authorization.navigation.AuthorizationDirections;
import com.trifcdr.navigationapi.NavigationApi;
import javax.inject.Inject;
import javax.inject.Provider;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0015\b\u0007\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/trifcdr/navigationimpl/navigatiomnapis/AuthorizationNavigationImpl;", "Lcom/trifcdr/navigationapi/NavigationApi;", "Lcom/trifcdr/authorization/navigation/AuthorizationDirections;", "navController", "Ljavax/inject/Provider;", "Landroidx/navigation/NavController;", "(Ljavax/inject/Provider;)V", "navigate", "", "direction", "navigationimpl_debug"})
public final class AuthorizationNavigationImpl implements com.trifcdr.navigationapi.NavigationApi<com.trifcdr.authorization.navigation.AuthorizationDirections> {
    @org.jetbrains.annotations.NotNull
    private final javax.inject.Provider<androidx.navigation.NavController> navController = null;
    
    @javax.inject.Inject
    public AuthorizationNavigationImpl(@org.jetbrains.annotations.NotNull
    javax.inject.Provider<androidx.navigation.NavController> navController) {
        super();
    }
    
    @java.lang.Override
    public void navigate(@org.jetbrains.annotations.NotNull
    com.trifcdr.authorization.navigation.AuthorizationDirections direction) {
    }
}