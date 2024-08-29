package com.diego.listadetarefascompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge

import com.diego.listadetarefascompose.ui.theme.ListaDeTarefasComposeTheme
import com.diego.listadetarefascompose.view.ListaTarefas
import com.diego.listadetarefascompose.view.SalvarTarefa

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ListaDeTarefasComposeTheme {

                val navController = rememberNavController()

                NavHost(navController = navController, startDestination = "listaTarefas"){
                    composable(
                        route = "listaTarefas"
                    ){
                        ListaTarefas(navController)
                    }
                    composable(
                        route = "salvarTarefa"
                    ){
                        SalvarTarefa(navController)
                    }

                }
            }
        }
    }
}

