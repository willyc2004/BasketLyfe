package com.example.basketlyfe.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.basketlyfe.ui.ListScreen
import kotlinx.coroutines.launch

class MasukViewModel (private val navController: NavController): ViewModel() {

    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun onEmailChanged(newEmail: String) {
        email = newEmail
    }

    fun onPasswordChanged(newPassword: String) {
        password = newPassword
    }

    fun onLoginClicked() {
        // Implement your login logic here
        // For example, you can use viewModelScope.launch for background tasks
        viewModelScope.launch {
            navController.navigate(ListScreen.MainScreen.name)
        }
    }
    fun onDaftarClicked() {
        // Handle any logic related to the Daftar button click
        navController.navigate(ListScreen.Daftar.name)
    }

    //contoh logout pak evan

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
