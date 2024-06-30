package com.thindie.physact.ui.List

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.thindie.physact.MainActivity
import com.thindie.physact.baseEvent.NavigationEvent
import com.thindie.physact.navigation.GraphEvent
import com.thindie.physact.navigation.NavGraph
import com.thindie.physact.ui.New.NewActivityScreenViewModel

fun NavGraph.Companion.list() {
    route(route = GraphEvent.ActivityList::class.java.name) {
        Box(){
            val provider = (LocalContext.current as MainActivity).dependenciesProvider
            val viewModel: ListScreenViewModel = viewModel(factory = provider.listScreenViewModelFactory)

            Button(onClick = { viewModel.onEvent(NavigationEvent.New) }) {
                Text("New")
            }
        }
    }
}