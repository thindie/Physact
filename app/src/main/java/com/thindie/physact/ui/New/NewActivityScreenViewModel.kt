package com.thindie.physact.ui.New

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.thindie.physact.baseEvent.Event
import com.thindie.physact.baseEvent.NavigationEvent
import com.thindie.physact.domain.Repository
import com.thindie.physact.navigation.GraphEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class NewActivityScreenViewModel(
    private val repository: Repository,
    private val routeFlow: MutableSharedFlow<GraphEvent>,
) :
    ViewModel() {
    fun onEvent(event: Event) {
        viewModelScope.launch {
            when (event) {
                NavigationEvent.Home -> {
                    routeFlow.emit(GraphEvent.Home)
                }

                NavigationEvent.List -> {
                    routeFlow.emit(GraphEvent.ActivityList)
                }

                NavigationEvent.New -> {
                    routeFlow.emit(GraphEvent.NewActivity)
                }
            }
        }
    }
}