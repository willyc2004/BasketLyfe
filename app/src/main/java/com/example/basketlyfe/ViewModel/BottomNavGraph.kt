package com.example.basketlyfe.viewmodel

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.basketlyfe.ui.ListScreen
import com.example.basketlyfe.ui.view.BottomBarScreen
import com.example.basketlyfe.ui.view.CompetitionLScreen
import com.example.basketlyfe.ui.view.CreateSchedule
import com.example.basketlyfe.ui.view.FormSchedule
import com.example.basketlyfe.ui.view.HomeScreen
import com.example.basketlyfe.ui.view.ProfileScreen
import com.example.basketlyfe.ui.view.ScheduleListScreen

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route=BottomBarScreen.Home.route){
            HomeScreen()
//            CreateSchedule(navController = navController)
        }
        composable(route=BottomBarScreen.Profile.route){
            ProfileScreen()
        }
        composable(route=BottomBarScreen.CompetitionL.route){
            CompetitionLScreen()
        }
        composable(route=BottomBarScreen.Schedule.route){
            ScheduleListScreen()
        }
        composable(route=BottomBarScreen.CreateSchedule.route){
            CreateSchedule(navController = navController)
        }


        composable(ListScreen.FormSchedule.name) {
            FormSchedule(viewModel = FormScheduleViewModel(navController = navController))
        }
    }
}
