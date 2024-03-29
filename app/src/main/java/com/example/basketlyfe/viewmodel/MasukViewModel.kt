package com.example.basketlyfe.viewmodel

import android.util.Log
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

class MasukViewModel (private val navController: NavController): ViewModel() {

    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun onEmailChanged(newEmail: String) {
        email = newEmail
    }

    fun onPasswordChanged(newPassword: String) {
        password = newPassword
    }

    fun onLoginClicked(
        email: String,
        password: String,
        dataStore: DataStoreManager,
        navController: NavController
    ) {
        // Implement your login logic here
        // For example, you can use viewModelScope.launch for background tasks
        viewModelScope.launch {
            try {
                val response = MyDBContainer().myDBRepositories.login(email, password)

                when {
                    response.message.equals("User not found", true) ||
                            response.message.equals("Incorrect Password", true) -> {
                        navController.navigate(ListScreen.Masuk.name)
                    }
                    response.message.equals("Token Created", true) -> {
                        if (response.data is List<*>) {
                            val data = response.data as List<*>
                            Log.d("Login response", response.data.toString())

                            if (data.size >= 2 && data[1] is String && data[0] is String) {
                                dataStore.saveToken(data[0] as String)
                                dataStore.saveEmail(data[1] as String)

                                navController.navigate(ListScreen.MainScreen.name)

                                dataStore.getEmail.collect {
                                    if (it != null) {
                                        MyDBContainer.EMAIL = it
                                        Log.d("Email", MyDBContainer.EMAIL)
                                    }
                                }

                                dataStore.getToken.collect {
                                    if (it != null) {
                                        MyDBContainer.ACCESS_TOKEN = it
                                        Log.d("Token", MyDBContainer.ACCESS_TOKEN)
                                    }
                                }
                            } else {
                                Log.d("Login Error", "Invalid data structure in response")
                            }
                        } else {
                            Log.d("Login Error", "Unexpected data type in response")
                        }
                    }
                    else -> {
                        Log.d("CekLogin", "MboAnehIki")
                    }
                }
            } catch (e: Exception) {
                Log.d("Login Error", e.message.toString())
                navController.navigate(ListScreen.Masuk.name)
            }
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
