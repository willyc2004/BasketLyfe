package com.example.basketlyfe.ui

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.basketlyfe.data.DataStoreManager
import com.example.basketlyfe.ui.view.CreateSchedule
import com.example.basketlyfe.ui.view.Daftar
import com.example.basketlyfe.ui.view.FormSchedule
import com.example.basketlyfe.ui.view.LoadingScreen
import com.example.basketlyfe.ui.view.MainScreen
import com.example.basketlyfe.ui.view.Masuk
import com.example.basketlyfe.viewmodel.DaftarViewModel
import com.example.basketlyfe.viewmodel.FormScheduleViewModel
import com.example.basketlyfe.viewmodel.LoadingScreenViewModel
import com.example.basketlyfe.viewmodel.MasukViewModel

enum class ListScreen {
    Masuk,
    Daftar,
    LoadingScreen,
    MainScreen,
    FormSchedule,
    CreateSchedule
}

@RequiresApi(Build.VERSION_CODES.O)
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
                LoadingScreen(viewModel = LoadingScreenViewModel(navController = navController))
            }
            composable(ListScreen.Masuk.name) {
                Masuk(viewModel = MasukViewModel(navController = navController), navController = navController, dataStore = DataStoreManager(context = LocalContext.current))
            }
            composable(ListScreen.Daftar.name) {
                Daftar(viewModel = DaftarViewModel(navController = navController), navController = navController, dataStore = DataStoreManager(context = LocalContext.current))
            }
            composable(ListScreen.MainScreen.name) {
                MainScreen()
            }
            composable(ListScreen.FormSchedule.name) {
                FormSchedule(viewModel = FormScheduleViewModel(navController = navController))
            }
            composable(ListScreen.CreateSchedule.name) {
                CreateSchedule(navController = navController)
            }
        }
    }
}

