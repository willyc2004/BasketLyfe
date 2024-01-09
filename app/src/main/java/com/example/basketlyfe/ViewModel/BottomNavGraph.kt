package com.example.basketlyfe.viewmodel

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.basketlyfe.ui.view.BottomBarScreen
import com.example.basketlyfe.ui.view.CompetitionLScreen
import com.example.basketlyfe.ui.view.HomeScreen
import com.example.basketlyfe.ui.view.ProfileScreen
import com.example.basketlyfe.ui.view.ScheduleListScreen

@Composable
fun BottomNavGraph(navController: NavHostController){
    NavHost(
        navController = navController,
        startDestination = BottomBarScreen.Home.route
    ){
        composable(route=BottomBarScreen.Home.route){
            HomeScreen()
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
    }
}
