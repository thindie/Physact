package com.thindie.physact.ui.New

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
 import com.thindie.physact.MainActivity
import com.thindie.physact.baseEvent.NavigationEvent
import com.thindie.physact.navigation.GraphEvent
import com.thindie.physact.navigation.NavGraph

fun NavGraph.Companion.new() {
    route(route = GraphEvent.NewActivity::class.java.name) {
         Box(modifier = Modifier){
             val provider = (LocalContext.current as MainActivity).dependenciesProvider
             val viewModel: NewActivityScreenViewModel = viewModel(factory = provider.newScreenViewModelFactory)

             Button(onClick = { viewModel.onEvent(NavigationEvent.Home) }) {
                 Text("Home")
             }
         }
    }
}