package com.trifcdr.di;

import java.lang.Exception
import javax.inject.Provider

abstract class BaseComponentHolder<
        COMPONENT : BaseApi,
        DEPENDENCIES : BaseDependencies
        >{

            private var component: COMPONENT? = null

            private lateinit var dependencyProvider: Provider<DEPENDENCIES>

            protected abstract fun build(dependencies: DEPENDENCIES): COMPONENT

            fun get(): COMPONENT = component ?: build(dependencyProvider.get())
                .also { newComp -> component = newComp }

            fun init(provider: Provider<DEPENDENCIES>){
                if (::dependencyProvider.isInitialized){
                    throw Exception("BaseComponentHolder must be initialized only once")
                }

                dependencyProvider = provider
            }

            fun clear() {
                component = null
            }




}
