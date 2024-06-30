package com.thindie.physact.ui.Home

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import com.thindie.physact.MainActivity
import com.thindie.physact.baseEvent.NavigationEvent
import com.thindie.physact.navigation.GraphEvent
import com.thindie.physact.navigation.NavGraph
import com.thindie.physact.ui.List.ListScreenViewModel

fun NavGraph.Companion.home() {
    route(route = GraphEvent.Home::class.java.name) {
        Box(){
            val provider = (LocalContext.current as MainActivity).dependenciesProvider
            val viewModel: HomeScreenViewModel = viewModel(factory = provider.homeViewModelFactory)

            Button(onClick = { viewModel.onEvent(NavigationEvent.List) }) {
                Text("List")
            }
        }
    }
}