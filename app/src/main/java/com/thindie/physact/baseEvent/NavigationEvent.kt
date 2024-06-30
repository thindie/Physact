package com.thindie.physact.baseEvent

sealed interface NavigationEvent: Event {
    data object Home: NavigationEvent
    data object New: NavigationEvent
    data object List: NavigationEvent
}

sealed interface Event