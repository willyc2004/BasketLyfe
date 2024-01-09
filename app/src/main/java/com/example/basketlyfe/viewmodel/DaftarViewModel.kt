package com.example.basketlyfe.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.basketlyfe.data.DataStoreManager
import com.example.basketlyfe.model.User
import com.example.basketlyfe.repositories.MyDBContainer
import com.example.basketlyfe.ui.ListScreen
import kotlinx.coroutines.launch

class DaftarViewModel (private val navController: NavController): ViewModel(){

    var email by mutableStateOf("")
    var name by mutableStateOf("")
    var password by mutableStateOf("")
    var konfirmasi by mutableStateOf("")
    private val _hasStrongPassword = MutableLiveData(false)
    val hasStrongPassword: LiveData<Boolean> get() = _hasStrongPassword

    fun updateHasStrongPassword(isStrong: Boolean) {
        _hasStrongPassword.value = isStrong
    }

    fun onEmailChanged(newEmail: String) {
        email = newEmail
    }

    fun onNameChanged(newName: String) {
        name = newName
    }

    fun onPasswordChanged(newPassword: String) {
        password = newPassword
    }

    fun onKonfirmasiChanged(newKonfirmasi: String) {
        konfirmasi = newKonfirmasi
    }

    fun onMasukClicked() {
        // Handle any logic related to the Daftar button click
        navController.navigate(ListScreen.Masuk.name)
    }

    // Example function for handling registration
    fun registerUser(
        name: String,
        email: String,
        password: String,
        dataStore: DataStoreManager,
        navController: NavController
    ) {
        if (validateForm()) {
            val user = User(
                email = email,
                name = name,
                password = password
            )
            viewModelScope.launch {
                try {
                    val response = MyDBContainer().myDBRepositories.register(user)

                    when {
                        response.message.equals("User already exists", true) -> {
                            // Handle user already exists case
                            Log.d("Register Error", "User already exists")
                        }
                        response.message.equals("User created", true) -> {
                            if (response.data is List<*>) {
                                val data = response.data as List<*>
                                Log.d("register response", response.data.toString())

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

                                    // TODO: Implement additional actions after successful registration

//                                    navController.navigate(ListScreen.MainScreen.name)
                                } else {
                                    Log.d("Register Error", "Invalid data structure in response")
                                }
                            } else {
                                Log.d("Register Error", "Unexpected data type in response")
                            }
                        }
                        else -> {
                            Log.d("Register Error", "Unexpected response: ${response.message}")
                        }
                    }
                } catch (e: Exception) {
                    Log.d("Register Error", e.message.toString())
                }
            }
        } else {
            // Handle validation errors or show a message to the user
            navController.navigate(ListScreen.Daftar.name)
        }
    }


    private fun validateForm(): Boolean {
        return email.isNotEmpty() && password.isNotEmpty() && konfirmasi.isNotEmpty()
                && password == konfirmasi && _hasStrongPassword.value == true
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
