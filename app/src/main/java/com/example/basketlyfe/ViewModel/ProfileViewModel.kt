package com.example.basketlyfe.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.basketlyfe.data.DataStoreManager
import com.example.basketlyfe.model.User
import com.example.basketlyfe.repositories.MyDBContainer
import com.example.basketlyfe.ui.ListScreen
import kotlinx.coroutines.launch

class ProfileViewModel : ViewModel() {

    var email by mutableStateOf("")
    var name by mutableStateOf("")

    fun updateUser(name: String, password: String, navController: NavController){
        viewModelScope.launch {
            try {
                val user = User(
                    email = MyDBContainer.EMAIL,
                    name = name,
                    password = password
                )

                val result = MyDBContainer().myDBRepositories.update_user(user)
                Log.d("SETTING SAVE SUCCESS", result.toString())

            }catch (e: Exception){
                Log.d("SETTING SAVE ERROR", e.message.toString())
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
                Log.d("Error", e.message.toString())
            }
        }
    }
}

