package com.example.basketlyfe.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController

class FormScheduleViewModel (private val navController: NavController): ViewModel(){

    var name by mutableStateOf("")
    var maxPlayer by mutableStateOf("")
//    var password by mutableStateOf("")





//    fun logout(
//        navController: NavController,
//        dataStore: DataStoreManager
//    ) {
//        viewModelScope.launch {
//            MyDBContainer().myDBRepositories.logout()
//            dataStore.saveToken("")
//            MyDBContainer.ACCESS_TOKEN = ""
//
//            navController.navigate(ListScreen.Login.name){
//                popUpTo(ListScreen.ListMovie.name){inclusive = true}
//            }
//        }
//    }
}
