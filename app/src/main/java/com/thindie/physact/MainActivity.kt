package com.thindie.physact

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.lifecycleScope
import com.thindie.physact.di.DependenciesProvider
import com.thindie.physact.navigation.GraphEvent
import com.thindie.physact.navigation.NavHost
import com.thindie.physact.navigation.rememberNavController
import com.thindie.physact.ui.Home.home
import com.thindie.physact.ui.List.list
import com.thindie.physact.ui.New.new
import com.thindie.physact.ui.theme.PhysactTheme

class MainActivity : ComponentActivity() {
    lateinit var dependenciesProvider: DependenciesProvider
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val application = application as ActivitiesApplication
            val navcontroller =
                rememberNavController(startDestination = GraphEvent.Home::class.java.name)
            dependenciesProvider =
                application.getDependenciesProvider(navcontroller, lifecycleScope)
            PhysactTheme {
                NavHost(navController = navcontroller) {
                    home()
                    list()
                    new()
                }
            }
        }
    }
}
