// Generated by Dagger (https://dagger.dev).
package com.trifcdr.navigationimpl.di;

import androidx.navigation.NavController;
import com.trifcdr.navigationimpl.NavigationActivityProvider;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class NavigationModuleImpl_ProvideNavControllerFactory implements Factory<NavController> {
  private final NavigationModuleImpl module;

  private final Provider<NavigationActivityProvider> activityProvider;

  public NavigationModuleImpl_ProvideNavControllerFactory(NavigationModuleImpl module,
      Provider<NavigationActivityProvider> activityProvider) {
    this.module = module;
    this.activityProvider = activityProvider;
  }

  @Override
  public NavController get() {
    return provideNavController(module, activityProvider.get());
  }

  public static NavigationModuleImpl_ProvideNavControllerFactory create(NavigationModuleImpl module,
      Provider<NavigationActivityProvider> activityProvider) {
    return new NavigationModuleImpl_ProvideNavControllerFactory(module, activityProvider);
  }

  public static NavController provideNavController(NavigationModuleImpl instance,
      NavigationActivityProvider activityProvider) {
    return Preconditions.checkNotNullFromProvides(instance.provideNavController(activityProvider));
  }
}
