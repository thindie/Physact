package com.thindie.physact.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.thindie.physact.data.RepositoryImpl
import com.thindie.physact.domain.Repository
import com.thindie.physact.navigation.GraphEvent
import com.thindie.physact.navigation.NavController
import com.thindie.physact.ui.Home.HomeScreenViewModel
import com.thindie.physact.ui.List.ListScreenViewModel
import com.thindie.physact.ui.New.NewActivityScreenViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class DependenciesProvider(private val navController: NavController, scope: CoroutineScope) {

    private val routingFlow = MutableSharedFlow<GraphEvent>()

    private val repository: Repository = RepositoryImpl()

    init {
        routingFlow
            .onEach {
                when (it) {
                    GraphEvent.Home -> navController.navigate(route = it::class.java.name)
                    GraphEvent.NewActivity -> navController.navigate(route = it::class.java.name)
                    GraphEvent.ActivityList -> navController.navigate(route = it::class.java.name)
                }
            }.launchIn(scope)
    }

    val newScreenViewModelFactory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(
            modelClass: Class<T>,
        ): T {
            return NewActivityScreenViewModel(
                repository = repository,
                routeFlow = routingFlow
            ) as T
        }
    }

    val listScreenViewModelFactory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(
            modelClass: Class<T>,
        ): T {
            return ListScreenViewModel(
                repository = repository,
                routeFlow = routingFlow
            ) as T
        }
    }

    val homeViewModelFactory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(
            modelClass: Class<T>,
        ): T {
            return HomeScreenViewModel(
                repository = repository,
                routeFlow = routingFlow
            ) as T
        }
    }
}