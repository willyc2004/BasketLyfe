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

class ProfileViewModel : ViewModel() {

    var email by mutableStateOf("")
    var name by mutableStateOf("")

    fun updateUser() {
        viewModelScope.launch {
            try {
                // Make API call to get user data and update email, name
//                val response = MyDBContainer().myDBRepositories.getUserData()
                // Update email and name based on the response
//                email = response.email
//                name = response.name
            } catch (e: Exception) {
                // Handle error (e.g., log or display a message)
            }
        }
    }

    fun logout(dataStore: DataStoreManager, navController: NavController) {
        viewModelScope.launch {
            try {
                MyDBContainer().myDBRepositories.logout()
                dataStore.saveToken("")
                MyDBContainer.ACCESS_TOKEN = ""
                navController.navigate(ListScreen.Masuk.name)
            } catch (e: Exception) {
                // Handle error (e.g., log or display a message)
            }
        }
    }
}

