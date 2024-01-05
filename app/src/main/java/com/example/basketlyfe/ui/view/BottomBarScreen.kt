package com.example.basketlyfe.ui.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

sealed class BottomBarScreen (
    val route: String,
    val title: String,
    val icon : ImageVector,
){

    object Profile : BottomBarScreen(
        route = "profile",
        title = "Profile",
        icon = Icons.Default.Person
    )
    object Home : BottomBarScreen(
        route = "home",
        title = "Home",
        icon = Icons.Default.Home
    )
    object CompetitionL : BottomBarScreen(
        route = "competitionL",
        title = "Competition",
        icon = Icons.Default.List
    )
    object Schedule : BottomBarScreen(
        route = "schedule",
        title = "Schedule",
        icon = Icons.Default.DateRange
    )
}
val String.color
    get()= Color(android.graphics.Color.parseColor(this))