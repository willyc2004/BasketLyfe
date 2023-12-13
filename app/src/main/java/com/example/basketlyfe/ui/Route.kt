package com.example.basketlyfe.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.basketlyfe.ui.view.Daftar
import com.example.basketlyfe.ui.view.LoadingScreen
import com.example.basketlyfe.ui.view.Masuk

enum class ListScreen {
    Masuk,
    Daftar,
    LoadingScreen,
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter", "CoroutineCreationDuringComposition")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasketLyfeRoute() {
    val navController = rememberNavController()

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = ListScreen.LoadingScreen.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(ListScreen.LoadingScreen.name) {
                LoadingScreen(navController = navController)
            }
            composable(ListScreen.Masuk.name) {
                Masuk(navController = navController)
            }
            composable(ListScreen.Daftar.name) {
                Daftar(navController = navController)
            }
        }
    }
}

