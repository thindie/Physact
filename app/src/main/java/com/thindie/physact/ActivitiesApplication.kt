package com.thindie.physact

import android.app.Application
import com.thindie.physact.di.DependenciesProvider
import com.thindie.physact.navigation.NavController
import kotlinx.coroutines.CoroutineScope

class ActivitiesApplication : Application() {
    private lateinit var dependenciesProvider: DependenciesProvider

    fun getDependenciesProvider(
        navController: NavController,
        coroutineScope: CoroutineScope,
    ): DependenciesProvider {
        if (!::dependenciesProvider.isInitialized) dependenciesProvider =
            DependenciesProvider(navController, coroutineScope)
        return dependenciesProvider
    }
}