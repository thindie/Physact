package com.thindie.physact.navigation

interface GraphEvent {
    data object Home: GraphEvent
    data object ActivityList: GraphEvent
    data object NewActivity: GraphEvent
}