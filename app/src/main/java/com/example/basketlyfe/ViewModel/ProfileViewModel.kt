package com.example.basketlyfe.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.basketlyfe.data.DataStoreManager
import com.example.basketlyfe.repositories.MyDBContainer
import com.example.basketlyfe.ui.ListScreen
import kotlinx.coroutines.launch

class ProfileViewModel (private val navController: NavController): ViewModel(){

    var email by mutableStateOf("")
    var name by mutableStateOf("")


    fun updateUser() {}
    fun logout(
        navController: NavController,
        dataStore: DataStoreManager
    ) {
        viewModelScope.launch {
            MyDBContainer().myDBRepositories.logout()
            dataStore.saveToken("")
            MyDBContainer.ACCESS_TOKEN = ""

            navController.navigate(ListScreen.Masuk.name)
        }
    }
}
