package com.trifcdr.di;

import java.lang.Exception
import javax.inject.Provider

abstract class BaseComponentHolder<
        COMPONENT : BaseApi,
        DEPENDENCIES : BaseDependencies
        >{

            private lateinit var dependencyProvider: Provider<DEPENDENCIES>

            private var component: COMPONENT? = null

            protected abstract fun build(dependencies: DEPENDENCIES): COMPONENT

            fun init(provider: Provider<DEPENDENCIES>){
                if (::dependencyProvider.isInitialized){
                    throw Exception("BaseComponentHolder must be initialized only once")
                }

                dependencyProvider = provider
            }

            fun get(): COMPONENT = component ?: build(dependencyProvider.get())
                .also { newComp -> component = newComp }

            fun clear() {
                component = null
            }




}
